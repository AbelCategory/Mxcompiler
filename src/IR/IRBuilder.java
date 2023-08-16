package IR;

import AST.*;
import Util.*;

import AST.ASTVistor;

public class IRBuilder implements ASTVistor {
    public globalScope gScope;
    public IRFunc gVarInit;
    public Scope currentScope;
    public module topModule;
    public IRFunc curFunc;
    public block curBlock;
    public voidType voidIR = new voidType();
    public I_Type intIR = new I_Type(32);
    public I_Type boolIR = new I_Type(1);
    public ptrType ptrIR = new ptrType(null);
    public IRString strIR = new IRString();
    public null_Type nullIR = new null_Type();
    public literalNull nullLit = new literalNull(nullIR);
    public literalBool falseLit = new literalBool(boolIR, false);
    public literalBool trueLit = new literalBool(boolIR, true);

    public IRBuilder(globalScope gScope) {
        this.gScope = gScope;
    }

    public IRType toIRType(Type t) {
        IRType tp;
        Type d = t.isArray() ? ((ArrayType) t).type : t;
        if(d.isInt()) {
            tp = intIR;
        } else if(d.isVoid()) {
            tp = voidIR;
        } else if(d.isBool()) {
            tp = boolIR;
        } else if(d.isString()) {
            tp = strIR;
        } else {
            tp = ptrIR;
        }
        if(t.isArray()) {
            tp = new ptrType(tp, ((ArrayType) t).dim);
        }
        return tp;
    }

    public IRType getIRType(Type t) {
        if(t.isInt()) return intIR;
        if(t.isBool()) return boolIR;
        return ptrIR;
    }

    @Override public void visit(rtNode cur) {
        currentScope = gScope;
        topModule = new module();
        gVarInit = new IRFunc("__cxx_global_var_init", voidIR);
        gVarInit.suite.set(0, gVarInit.entry);
        topModule.addFunc(gVarInit);
        cur.classDef.forEach(this::visitClassDef);
        cur.varDef.forEach(v -> v.accept(this));
        cur.funcDef.forEach(f -> f.accept(this));
//        cur.funcDef.forEach(addFunRet);
//        cur.def.forEach(x -> x.accept(this));
        gVarInit.suite.get(gVarInit.suite.size() - 1).addInst(new ret());
    }

    public void visitClassDef(classNode cur) {
        IRClass c = new IRClass(cur.name);
        cur.varDef.forEach(x -> {
            x.var.forEach(v -> {
                c.addMember(getIRType(gScope.getType(x.type, null)));
            });
        });
        topModule.addClass(c);
    }

    @Override public void visit(classNode cur) {
//        IRFunc fun = new IRFunc(cur.name, voidIR);

    }

    @Override public void visit(funcNode cur) {
        IRFunc fun = new IRFunc(cur.name, toIRType(gScope.getType(cur.tp, null)));
        topModule.addFunc(fun);
        currentScope = new Scope(currentScope);
        block entry = fun.suite.get(0);
        curBlock = entry;
        cur.pa.forEach(p -> {
            IRType tp = toIRType(gScope.getType(cur.tp, null));
            reg par = new reg(p.name, tp);
            fun.addAugment(par);
            localVar res = new localVar(p.name + ".addr", tp);
            fun.addVarDef(tp, res);
            entry.addInst(new store(tp, par, res));
            currentScope.newVarEntity(p.name, res);
        });
        curFunc = fun;
        cur.body.stats.forEach(s -> s.accept(this));
        curFunc.entry.stats.addAll(curFunc.suite.get(0).stats);
        curFunc.suite.set(0, curFunc.entry);
        currentScope = currentScope.getParentScope();
    }

    @Override public void visit(varDefNode cur) {
        if(currentScope instanceof globalScope) {
            visitGlobalVar(cur);
        } else {
            visitLocalVar(cur);
        }
    }

    @Override public void visit(varNode x) {}

    public void visitGlobalVar(varDefNode cur) {
        curFunc = gVarInit;
        curBlock = curFunc.suite.get(0);
        cur.var.forEach(v -> {
            IRType type = toIRType(gScope.getType(cur.type, null));
            globalVar w = new globalVar(v.name, new ptrType(type));
            topModule.addVar(w);
            gScope.newVarEntity(v.name, w);
            if(v.body != null) {
                v.body.accept(this);
                if(v.body.ent instanceof literal) {
                    w.val = v.body.ent;
                } else {
                    curBlock.addInst(new store(type, v.body.ent, w));
                }
            }
        });
    }

    public void visitLocalVar(varDefNode cur) {
        cur.var.forEach(v -> {
            IRType type = toIRType(gScope.getType(cur.type, null));
            localVar w = new localVar(v.name, new ptrType(type));
            curFunc.addVarDef(type, w);
            currentScope.newVarEntity(v.name, w);
            if(v.body != null) {
                v.body.accept(this);
                curBlock.addInst(new store(type, v.body.ent, w));
            }
        });
    }

    @Override public void visit(BlockStatNode cur) {
        if(!cur.isnw) currentScope = new Scope(currentScope);
        cur.stats.forEach(st -> st.accept(this));
        if(!cur.isnw) currentScope = currentScope.getParentScope();
    }
    @Override public void visit(IfStatNode cur) {
        cur.cond.accept(this);
        if(cur.cond.ent instanceof literal) {
            literalBool cond = (literalBool) cur.cond.ent;
            if(cond.val) {
                cur.thenStat.accept(this);
            } else {
                cur.elseStat.accept(this);
            }
            return;
        }
        block thenBlock = new block("if.then"), elseBlock = new block("if.else");
        block endBlock = new block("if.end");
        currentScope = new Scope(currentScope);
        curBlock.addInst(new br(cur.cond.ent, thenBlock.L, elseBlock.L));
        curFunc.addBlock(thenBlock);
        curBlock = thenBlock;
        cur.thenStat.accept(this);
        curBlock.addInst(new br(endBlock.L));
        currentScope = currentScope.getParentScope();
        if(cur.elseStat != null) {
            currentScope = new Scope(currentScope);
            curFunc.addBlock(elseBlock);
            curBlock = elseBlock;
            cur.elseStat.accept(this);
            curBlock.addInst(new br(endBlock.L));
            currentScope = currentScope.getParentScope();
        }
        curFunc.addBlock(endBlock);
        curBlock = endBlock;
    }

    public void visitForLoop(ForStatNode cur) {
        block cond = new block("for.cond"), body = new block("for.body"), step = new block("for.step"), end = new block("for.end");
        curFunc.addBlock(cond);
        curBlock.addInst(new br(cond.L));
        curBlock = cond;
        currentScope.loopCond = cond.L;
        currentScope.loopEnd = end.L;
        if(cur.cond != null) {
            cur.cond.accept(this);
            curBlock.addInst(new br(cur.cond.ent, body.L, end.L));
            curBlock = body;
            curFunc.addBlock(body);
        }
        cur.body.accept(this);
        if(cur.step != null) {
            curFunc.addBlock(step);
            curBlock.addInst(new br(step.L));
            curBlock = step;
            if (cur.step != null) cur.step.accept(this);
        }
        curBlock.addInst(new br(cond.L));
        curBlock = end;

    }
    @Override public void visit(ForDefStatNode cur) {
        currentScope = new Scope(currentScope);
        if(cur.init != null) cur.init.accept(this);
        visitForLoop(cur);
        currentScope = currentScope.getParentScope();
    }
    @Override public void visit(ForExpStatNode cur) {
        currentScope = new Scope(currentScope);
        if(cur.init != null) cur.init.accept(this);
        visitForLoop(cur);
        currentScope = currentScope.getParentScope();
    }
    @Override public void visit(WhileStatNode cur) {
        currentScope = new Scope(currentScope);
        block cond = new block("while.cond"), body = new block("while.body"), end = new block("while.end");
        currentScope.loopCond = cond.L;
        currentScope.loopEnd = end.L;
        curBlock.addInst(new br(cond.L));
        curBlock = cond;
        cur.cond.accept(this);
        curBlock.addInst(new br(cur.cond.ent, body.L, end.L));
        curBlock = body;
        cur.body.accept(this);
        curBlock.addInst(new br(cond.L));
        curBlock = end;
        currentScope = currentScope.getParentScope();
    }
    @Override public void visit(breakStatNode cur) {
        curBlock.addInst(new br(currentScope.loopEnd));
    }

    @Override public void visit(continueStatNode cur) {
        curBlock.addInst(new br(currentScope.loopEnd));
    }

    @Override public void visit(returnStatNode cur) {
        if(cur.expr != null) {
            cur.expr.accept(this);
            curBlock.addInst(new ret(cur.expr.ent)) ;
        } else {
            curBlock.addInst(new ret());
        }
    }

    @Override public void visit(exprStatNode cur) {
        cur.expr.accept(this);
    }

    @Override public void visit(binaryExpNode cur) {
        switch (cur.op) {
            case EQ, NEQ, LE, GR, LEQ, GEQ -> {
                cur.lhs.accept(this);
                cur.rhs.accept(this);
                if((cur.lhs.ent instanceof literal) && (cur.rhs.ent instanceof literal)) {
                    switch (cur.op) {
                        case EQ, NEQ -> {
                            boolean iseq = cur.op == BinaryOperator.EQ;
                            if(cur.lhs.ent instanceof literalInt lhs) {
                                literalInt rhs = (literalInt) cur.rhs.ent;
                                cur.ent = new literalBool((boolIR), iseq == (lhs.val == rhs.val));
                            } else if(cur.lhs.ent instanceof literalBool lhs) {
                                literalBool rhs = (literalBool) cur.rhs.ent;
                                cur.ent = new literalBool((boolIR), iseq == (lhs.val == rhs.val));
                            } else if(cur.lhs.ent instanceof literalNull) {
                                cur.ent = iseq ? trueLit : falseLit;
                            } else if(cur.lhs.ent instanceof literalStr lhs) {
                                literalStr rhs = (literalStr) cur.rhs.ent;
                                cur.ent = new literalBool((boolIR), iseq == lhs.val.equals(rhs.val));
                            }
                        }
                        case LE, GEQ -> {
                            boolean isle = cur.op == BinaryOperator.LE;
                            if(cur.lhs.ent instanceof literalInt lhs) {
                                literalInt rhs = (literalInt) cur.rhs.ent;
                                cur.ent = new literalBool((boolIR), isle == (lhs.val < rhs.val));
                            } else if(cur.lhs.ent instanceof literalStr lhs) {
                                literalStr rhs = (literalStr) cur.rhs.ent;
                                cur.ent = new literalBool((boolIR), isle == (lhs.val.compareTo(rhs.val) < 0));
                            }
                        }
                        case GR, LEQ -> {
                            boolean isge = cur.op == BinaryOperator.GR;
                            if(cur.lhs.ent instanceof literalInt lhs) {
                                literalInt rhs = (literalInt) cur.rhs.ent;
                                cur.ent = new literalBool((boolIR), isge == (lhs.val > rhs.val));
                            } else if(cur.lhs.ent instanceof literalStr lhs) {
                                literalStr rhs = (literalStr) cur.rhs.ent;
                                cur.ent = new literalBool((boolIR), isge == (lhs.val.compareTo(rhs.val) > 0));
                            }
                        }
                    }
                    return;
                }
                reg res = new reg(cur.op.toString().toLowerCase(), boolIR);
                curBlock.addInst(new icmp(cur.op, cur.lhs.ent, cur.rhs.ent, res));
                cur.ent = res;
            }
            case ADD, SUB, MUL, DIV, MOD, BAND, BOR, BXOR, LSH, RSH -> {
                cur.lhs.accept(this);
                cur.rhs.accept(this);
                reg res = new reg(cur.op.toString().toLowerCase(), intIR);
                if((cur.lhs.ent instanceof literal) && (cur.rhs.ent instanceof literal)) {
                    switch (cur.op) {
                        case ADD -> {
                            if(cur.lhs.ent instanceof literalInt) {
                                cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val + ((literalInt) cur.rhs.ent).val);
                            } else if(cur.lhs.ent instanceof literalStr) {
                                cur.ent = new literalStr(strIR, ((literalStr) cur.lhs.ent).val + ((literalStr) cur.rhs.ent).val);
                            }
                        }
                        case SUB -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val - ((literalInt) cur.rhs.ent).val);
                        case MUL -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val * ((literalInt) cur.rhs.ent).val);
                        case DIV -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val / ((literalInt) cur.rhs.ent).val);
                        case MOD -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val % ((literalInt) cur.rhs.ent).val);

                        case BAND -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val & ((literalInt) cur.rhs.ent).val);
                        case BOR -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val | ((literalInt) cur.rhs.ent).val);
                        case BXOR -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val ^ ((literalInt) cur.rhs.ent).val);
                        case LSH -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val << ((literalInt) cur.rhs.ent).val);
                        case RSH -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val >> ((literalInt) cur.rhs.ent).val);
                    }
                }
                curBlock.addInst(new arith(cur.op, cur.lhs.ent, cur.rhs.ent, res));
                cur.ent = res;
            }
            case LAND, LOR -> {
                cur.lhs.accept(this);
                reg res = new reg(cur.op.toString().toLowerCase(), boolIR);
                if(cur.lhs.ent instanceof literalBool) {
                    literalBool lhs = (literalBool) cur.lhs.ent;
                    if(lhs.val == (cur.op == BinaryOperator.LOR)) {
                        cur.ent = lhs;
                    } else {
                        cur.ent = cur.rhs.ent;
                    }
                    return;
                }
                block pre = curBlock, block1 = new block(cur.op.toString().toLowerCase() + ".rhs");
                block block2 = new block(cur.op.toString().toLowerCase() + ".end");
                phi P = new phi(res);
                curFunc.addBlock(block1);
                curFunc.addBlock(block2);
                if (cur.op == BinaryOperator.LAND) {
                    pre.addInst(new br(cur.lhs.ent, block1.L, block2.L));
                    curBlock = block1;
                    cur.rhs.accept(this);
                    curBlock = block2;
                    P.addVal(pre.L, falseLit);
                    P.addVal(block1.L, cur.rhs.ent);
                    curBlock.addInst(P);
                } else {
                    pre.addInst(new br(cur.lhs.ent, block2.L, block1.L));
                    curBlock = block1;
                    cur.rhs.accept(this);
                    curBlock = block2;
                    P.addVal(pre.L, trueLit);
                    P.addVal(block2.L, cur.rhs.ent);
                    curBlock.addInst(P);
                }
                cur.ent = res;
            }
        }
    }

    @Override public void visit(unaryExpNode cur) {
        cur.e.accept(this);
        if(cur.e.ent instanceof literal) {
            switch (cur.op) {
                case BNOT -> cur.ent = new literalInt((intIR), ~((literalInt) cur.e.ent).val);
                case LNOT -> cur.ent = new literalBool((boolIR), !((literalBool) cur.e.ent).val);
                case POS -> cur.ent = new literalInt((intIR), ((literalInt) cur.e.ent).val);
                case NEG -> cur.ent = new literalInt((intIR), -((literalInt) cur.e.ent).val);
            }
        } else {
            switch (cur.op) {
                case BNOT -> {
                    reg res = new reg(cur.op.name().toLowerCase(), intIR);
                    curBlock.addInst(new arith(BinaryOperator.BXOR, cur.e.ent, new literalInt(intIR, -1), res));
                    cur.ent = res;

                }
                case LNOT -> {
                    reg res = new reg(cur.op.name().toLowerCase(), boolIR);
                    curBlock.addInst(new arith(BinaryOperator.BXOR, cur.e.ent, new literalBool(boolIR, true), res));
                    cur.ent = res;
                }
                case POS -> cur.ent = cur.e.ent;
                case NEG -> {
                    reg res = new reg(cur.op.name().toLowerCase(), intIR);
                    curBlock.addInst(new arith(BinaryOperator.SUB, new literalInt(intIR, 0), cur.e.ent, res));
                    cur.ent = res;
                }
            }
        }
    }

    @Override public void visit(postUpdateExpNode cur) {
        cur.e.accept(this);
        reg res = new reg(cur.op.toString().toLowerCase(), intIR);
        BinaryOperator op = cur.op == UPDOperator.INC ? BinaryOperator.ADD : BinaryOperator.SUB;
        curBlock.addInst(new arith(op, cur.e.ent, new literalInt(intIR, 1), res));
        curBlock.addInst(new store(intIR, res, cur.e.ptr));
        cur.ent = res;
    }

    @Override public void visit(preUpdateExpNode cur) {
        cur.e.accept(this);
        reg res = new reg(cur.op.toString().toLowerCase(), intIR);
        BinaryOperator op = cur.op == UPDOperator.INC ? BinaryOperator.ADD : BinaryOperator.SUB;
        curBlock.addInst(new arith(op, cur.e.ent, new literalInt(intIR, 1), res));
        curBlock.addInst(new store(intIR, res, cur.e.ptr));
        cur.ent = cur.e.ent;
    }

    @Override public void visit(condExpNode cur) {
        cur.cond.accept(this);
        if(cur.cond.ent instanceof literalBool) {
            if(((literalBool) cur.cond.ent).val) {
                cur.exp1.accept(this);
                cur.ent = cur.exp1.ent;
            } else {
                cur.exp2.accept(this);
                cur.ent = cur.exp2.ent;
            }
        } else {
            block pre = curBlock;
            block block1 = new block("cond.trueBranch"), block2 = new block("cond.falseBranch");
            block block3 = new block("cond.end");
            curFunc.addBlock(block1);
            curFunc.addBlock(block2);
            curFunc.addBlock(block3);
            reg res = new reg("cond", toIRType(cur.type));
            pre.addInst(new br(cur.cond.ent, block1.L, block2.L));

            curBlock = block1;
            cur.exp1.accept(this);
            block1.addInst(new br(block3.L));

            curBlock = block2;
            cur.exp2.accept(this);
            block2.addInst(new br(block3.L));

            curBlock = block3;
            if(!cur.type.isVoid()) {
                phi p = new phi(res);
                p.addVal(block1.L, cur.exp1.ent);
                p.addVal(block2.L, cur.exp2.ent);
                block3.addInst(p);
                cur.ent = res;
            }
        }
    }

    @Override public void visit(assignNode cur) {
        cur.rhs.accept(this);
        cur.lhs.isLeft = true;
        cur.lhs.accept(this);
        curBlock.addInst(new store(toIRType(cur.lhs.type), cur.rhs.ent, cur.lhs.ptr));
        cur.ent = cur.rhs.ent;
    }

    @Override public void visit(funCallNode cur) {
        reg res;
        if(cur.type.isVoid()) res = null;
        else res = new reg(cur.funcName + ".res", toIRType(cur.type));
        call c = new call(res, cur.funcName);
        c.retType = toIRType(gScope.getFunc(cur.funcName, null).returnType);
        cur.arguments.forEach(p -> {
            p.accept(this);
            c.addParameter(p.ent);
        });
        curBlock.addInst(c);
        cur.ent = res;
    }

    @Override public void visit(memberFuncNode cur) {
        reg res;
        String name = cur.obj.type.Typename + "::" + cur.funcName;
        if(cur.type.isVoid()) res = null;
        else res = new reg(name + ".res", toIRType(cur.type));
        call c = new call(res, name);
        c.retType = toIRType(gScope.getFunc(name, null).returnType);
        cur.obj.accept(this);
        c.addParameter(cur.obj.ent);
        cur.arguments.forEach(p -> {
            p.accept(this);
            c.addParameter(p.ent);
        });
        curBlock.addInst(c);
        cur.ent = res;
    }

    @Override public void visit(memberVarNode cur) {
        String name = cur.obj.type.Typename + "::" + cur.varName;
        reg ptr = new reg(cur.varName, new ptrType(toIRType(currentScope.getVarType(name, null))));
        cur.obj.accept(this);
        cur.obj.isLeft = true;
        curBlock.addInst(new getelementptr(ptr, cur.obj.ent, toIRType(cur.obj.type), new literalInt(intIR, gScope.getVarIndex(name))));
        cur.ptr = ptr;
        if(!cur.isLeft) {
            reg res = new reg("local_var", toIRType(cur.type));
            curBlock.addInst(new load(toIRType(cur.type), res, ptr));
        }
    }

    @Override public void visit(ArrayExpNode cur) {

    }

    @Override public void visit(varExpNode cur) {
        entity v = currentScope.getVarEntity(cur.name);
        cur.ptr = v;
        if(!cur.isLeft) {
            reg res = new reg("local_var", toIRType(cur.type));
            curBlock.addInst(new load(toIRType(cur.type), res, v));
            cur.ent = res;
        }
    }

    @Override public void visit(NewExpNode cur) {}

    @Override public void visit(constExprNode cur) {
        if(cur.type.isInt()) {
            cur.ent = new literalInt(intIR, ((IntNode) cur).value);
        } else if(cur.type.isBool()) {
            cur.ent = new literalBool(boolIR, ((BoolNode) cur).value);
        } else if(cur.type.isNull()) {
            cur.ent = nullLit;
        } else if(cur.type.isString()) {
            cur.ent = new literalStr(strIR, ((StringNode) cur).value);
        }
    }

    @Override public void visit(ThisNode cur) {}
}
