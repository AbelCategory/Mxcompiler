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
    public IRClass curClass;
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
    public literalInt zeroLit = new literalInt(intIR, 0);
    public literalInt oneLit = new literalInt(intIR, 1);
    public builtin Built;

    public IRBuilder(globalScope gScope) {
        this.gScope = gScope;
        topModule = new module();
        Built = new builtin(this);
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
            tp = new ptrType(gScope.irt.get(t.getTypename()));
        }
        if(t.isArray()) {
            tp = new ptrType(tp, ((ArrayType) t).dim - 1);
        }
        return tp;
    }

//    public IRType getIRType(Type t) {
//        if(t.isInt()) return intIR;
//        if(t.isBool()) return boolIR;
//        return ptrIR;
//    }

    @Override public void visit(rtNode cur) {
        currentScope = gScope;
        gVarInit = new IRFunc("__cxx_global_var_init", voidIR);
        topModule.addFunc(gVarInit);
        cur.classDef.forEach(c -> {
            IRClass cl = new IRClass(c.name);
            if(c.constructor != null) {
                cl.constructor = true;
            }
            c.varDef.forEach(vd -> {
                IRType t = toIRType(gScope.getType(vd.type, null));
                vd.var.forEach(ve -> cl.addMember(t, ve.name));
            });
            gScope.irt.put(c.name, cl);
        });

        curBlock = gVarInit.suite.get(0);
        cur.varDef.forEach(v -> v.accept(this));

        cur.classDef.forEach(c -> c.accept(this));

        cur.funcDef.forEach(f -> f.accept(this));
        cur.mainFn.accept(this);
//        cur.funcDef.forEach(addFunRet);
//        cur.def.forEach(x -> x.accept(this));
        gVarInit.entry.stats.addAll(gVarInit.suite.get(0).stats);
        gVarInit.suite.set(0, gVarInit.entry);
        gVarInit.suite.get(gVarInit.suite.size() - 1).addInst(new ret());
    }

    @Override public void visit(classNode cur) {
        currentScope = new Scope(currentScope);
        curClass = (IRClass) gScope.irt.get(cur.name);
        topModule.addClass(curClass);
        cur.varDef.forEach(x -> {
            x.var.forEach(v ->
                    currentScope.newVarEntity(v.name, new localVar(v.name, toIRType(gScope.getType(x.type, null)))));
        });
        cur.funcDef.forEach(f -> curClass.addMemberFun(f.name));
        if(cur.constructor != null) {
            visitConstructor(cur.constructor);
        }
        cur.funcDef.forEach(f -> visitMemFun(cur.name, f));
        currentScope = currentScope.getParentScope();
        curClass = null;
    }

    public void visitConstructor(funcNode cur) {
        currentScope = new Scope(currentScope);
        IRFunc fun = new IRFunc("constructor." + cur.name, voidIR);
        fun.ret = new block("return", true);
        fun.ret.addInst(new ret());
        curFunc = fun;
        topModule.addFunc(curFunc);
        ptrType pt = new ptrType(curClass);
        reg par = new reg("this", pt);
        fun.addAugment(par);
        localVar res = new localVar("this.addr", new ptrType(pt));
        fun.addVarDef(pt, res);
        block entry = fun.suite.get(0);
        entry.addInst(new store(pt, par, res));
        currentScope.newVarEntity("this", res);
        curFunc = fun;
        curBlock = entry;
        cur.body.stats.forEach(s -> s.accept(this));
        if(curBlock != null && !curBlock.isReturned) {
            curBlock.addInst(new br(fun.ret.L));
        }
        curFunc.entry.stats.addAll(curFunc.suite.get(0).stats);
        curFunc.suite.set(0, curFunc.entry);
        currentScope = currentScope.getParentScope();
        fun.addBlock(fun.ret);
    }

    public void visitMemFun(String cls, funcNode cur) {
        currentScope = new Scope(currentScope);
        IRFunc fun = new IRFunc("member_fun." + cls + "." + cur.name, toIRType(gScope.getType(cur.tp, null)));
        topModule.addFunc(fun);
        block entry = fun.suite.get(0);
        curBlock = entry;
        fun.ret = new block("return", true);
        ptrType pt = new ptrType(curClass);
        reg par = new reg("this", pt);
        fun.addAugment(par);
        localVar res = new localVar("this.addr", new ptrType(pt));
        fun.addVarDef(pt, res);
        entry.addInst(new store(pt, par, res));
        currentScope.newVarEntity("this", res);
        curFunc = fun;
        curBlock = entry;
        visitFunPara(cur, fun, entry);
        visitFuncBody(cur, entry);
        if(curFunc.retype instanceof voidType) {
            curBlock = curFunc.ret;
            curBlock.addInst(new ret());
            curFunc.addBlock(curBlock);

        } else {
            curBlock = curFunc.ret;
            reg resc = new reg("ret_val", curFunc.retype);
            curBlock.addInst(new load(curFunc.retype, resc, curFunc.retReg));
            curBlock.addInst(new ret(resc));
            curFunc.addBlock(curBlock);
        }

        curFunc.entry.stats.addAll(curFunc.suite.get(0).stats);
        curFunc.suite.set(0, curFunc.entry);
        currentScope = currentScope.getParentScope();

    }

    @Override public void visit(funcNode cur) {
        String name = cur.name;
        if(!cur.name.equals("main")) name = "fun." + name;
        IRFunc fun = new IRFunc(name, toIRType(gScope.getType(cur.tp, null)));
        topModule.addFunc(fun);
        currentScope = new Scope(currentScope);
        block entry = fun.suite.get(0);
        if(cur.name.equals("main")) {
            call init = new call(null, "__cxx_global_var_init");
            init.retType = voidIR;
            entry.addInst(init);
        }
        curBlock = entry;
        fun.ret = new block("return", true);
        visitFunPara(cur, fun, entry);
        curFunc = fun;
        visitFuncBody(cur, entry);
        if(curFunc.retype instanceof voidType) {
            curBlock = curFunc.ret;
            curBlock.addInst(new ret());
            curFunc.addBlock(curBlock);
        } else {
            curBlock = curFunc.ret;
            reg res = new reg("ret_val", curFunc.retype);
            curBlock.addInst(new load(curFunc.retype, res, curFunc.retReg));
            curBlock.addInst(new ret(res));
            curFunc.addBlock(curBlock);
        }
        curFunc.entry.stats.addAll(curFunc.suite.get(0).stats);
        curFunc.suite.set(0, curFunc.entry);
        currentScope = currentScope.getParentScope();
    }

    private void visitFunPara(funcNode cur, IRFunc fun, block entry) {
        cur.pa.forEach(p -> {
            IRType tp = toIRType(gScope.getType(p.type, null));
            reg par = new reg(p.name, tp);
            fun.addAugment(par);
            localVar res = new localVar(p.name + ".addr", tp);
            fun.addVarDef(tp, res);
            entry.addInst(new store(tp, par, res));
            currentScope.newVarEntity(p.name, res);
        });
    }

    private void visitFuncBody(funcNode cur, block entry) {
        if(!(curFunc.retype instanceof voidType)) {
            curFunc.retReg = new localVar("retVal", new ptrType(curFunc.retype));
            curFunc.addVarDef(curFunc.retype, curFunc.retReg);
        }
        cur.body.stats.forEach(s -> s.accept(this));
        if(curBlock != null && !curBlock.isReturned) {
            curBlock.addInst(new br(curFunc.ret.L));
        }
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
        block endBlock = new block("if.end");
        block thenBlock = new block("if.then");
        block elseBlock = cur.elseStat != null ? (new block("if.else")) : endBlock;
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
        currentScope.loopContinue = cur.step != null ? step.L : cond.L;
        currentScope.loopEnd = end.L;
        if(cur.cond != null) {
            cur.cond.accept(this);
            curBlock.addInst(new br(cur.cond.ent, body.L, end.L));
            curBlock = body;
            curFunc.addBlock(body);
        }
        currentScope = new Scope(currentScope);
        cur.body.accept(this);
        currentScope = currentScope.getParentScope();
        if(cur.step != null) {
            curFunc.addBlock(step);
            curBlock.addInst(new br(step.L));
            curBlock = step;
            if (cur.step != null) cur.step.accept(this);
        }
        curBlock.addInst(new br(cond.L));
        curBlock = end;
        curFunc.addBlock(end);
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
        currentScope.loopContinue = cond.L;
        currentScope.loopEnd = end.L;
        curFunc.addBlock(cond);
        curFunc.addBlock(body);
        curFunc.addBlock(end);
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
        curBlock.addInst(new br(currentScope.loopContinue));
    }

    @Override public void visit(returnStatNode cur) {
        if(cur.expr != null) {
            cur.expr.accept(this);
            curBlock.addInst(new store(curFunc.retype, cur.expr.ent, curFunc.retReg));
            curBlock.addInst(new br(curFunc.ret.L));
            curBlock.isReturned = true;
//            curBlock.addInst(new ret(cur.expr.ent)) ;
        } else {
//            curBlock.addInst(new ret());
            curBlock.isReturned = true;
            curBlock.addInst(new br(curFunc.ret.L));
        }
    }

    @Override public void visit(exprStatNode cur) {
        cur.expr.accept(this);
    }

    private void add_call(String func, entity ls, entity rs, reg res, IRType ret) {
        call c = new call(res, func);
        c.addParameter(ls);
        c.addParameter(rs);
        c.retType = ret;
        curBlock.addInst(c);
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
                if(cur.lhs.type.isInt()) {
                    curBlock.addInst(new icmp(cur.op, cur.lhs.ent, cur.rhs.ent, res));
                } else if(cur.lhs.type.isString()) {
                    switch (cur.op) {
                        case EQ -> add_call("string_eq", cur.lhs.ent, cur.rhs.ent, res, boolIR);
                        case NEQ -> add_call("string_neq", cur.lhs.ent, cur.rhs.ent, res, boolIR);
                        case LE -> add_call("string_lt", cur.lhs.ent, cur.rhs.ent, res, boolIR);
                        case LEQ -> add_call("string_le", cur.lhs.ent, cur.rhs.ent, res, boolIR);
                        case GR -> add_call("string_gt", cur.lhs.ent, cur.rhs.ent, res, boolIR);
                        case GEQ -> add_call("string_ge", cur.lhs.ent, cur.rhs.ent, res, boolIR);
                    }
                } else {
                    curBlock.addInst(new icmp(cur.op, cur.lhs.ent, cur.rhs.ent, res));
                }
                cur.ent = res;
            }
            case ADD, SUB, MUL, DIV, MOD, BAND, BOR, BXOR, LSH, RSH -> {
                cur.lhs.accept(this);
                cur.rhs.accept(this);
                if((cur.lhs.ent instanceof literal) && (cur.rhs.ent instanceof literal)) {
                    switch (cur.op) {
                        case ADD -> {
                            if(cur.lhs.ent instanceof literalStr) {
                                literalStr ptr = new literalStr(strIR, ((literalStr) cur.lhs.ent).val + ((literalStr) cur.rhs.ent).val);
                                topModule.str.add(ptr);
                                cur.ent = ptr;
                            } else {
                                cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val + ((literalInt) cur.rhs.ent).val);
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
                    return;
                }
                if(cur.lhs.type.isString() && cur.op == BinaryOperator.ADD) {
                    reg res = new reg(cur.op.toString().toLowerCase(), strIR);
                    add_call("string_add", cur.lhs.ent, cur.rhs.ent, res, strIR);
                    cur.ent = res;
                    return;
                }
                reg res = new reg(cur.op.toString().toLowerCase(), intIR);
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
                    curBlock.addInst(new br(block2.L));
                    curBlock = block2;
                    P.addVal(pre.L, falseLit);
                    P.addVal(block1.L, cur.rhs.ent);
                    curBlock.addInst(P);
                } else {
                    pre.addInst(new br(cur.lhs.ent, block2.L, block1.L));
                    curBlock = block1;
                    cur.rhs.accept(this);
                    curBlock.addInst(new br(block2.L));
                    curBlock = block2;
                    P.addVal(pre.L, trueLit);
                    P.addVal(block1.L, cur.rhs.ent);
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
        entity res;
        if(cur.lhs.type.isBool() && !(cur.lhs.isSingle)) {
            res = new reg("frombool", intIR);
            curBlock.addInst(new convert(res, cur.rhs.ent, intIR, boolIR, convert.conv.ZEXT));
        } else {
            res = cur.rhs.ent;
        }
        curBlock.addInst(new store(toIRType(cur.lhs.type), res, cur.lhs.ptr));
        cur.ent = cur.rhs.ent;
    }

    @Override public void visit(funCallNode cur) {
        reg res;
        if(cur.type.isVoid()) res = null;
        else res = new reg(cur.funcName + ".res", toIRType(cur.type));
        String name = "fun." + cur.funcName;
        if(gScope.irf.containsKey(cur.funcName)) name = gScope.irf.get(cur.funcName);
        else if(curClass != null && curClass.funDefined(cur.funcName)) name = "member_fun." + curClass.name + "." + cur.funcName;;
        call c = new call(res, name);
        c.retType = toIRType(cur.type);
        if(curClass != null && curClass.funDefined(cur.funcName)) {
            entity This = currentScope.getVarEntity("this");
//            String cur_name = curClass.name + ;
            reg cur_this = new reg("this_ptr", ptrIR);
            IRType tp = ((ptrType) This.type).type;
            curBlock.addInst(new load(ptrIR, cur_this, This));
            c.addParameter(cur_this);
        }
        cur.arguments.forEach(p -> {
            p.accept(this);
            c.addParameter(p.ent);
        });
        curBlock.addInst(c);
        cur.ent = res;
    }

    @Override public void visit(memberFuncNode cur) {
        reg res;
        String name = cur.obj.type.getTypename() + "::" + cur.funcName;
        if(gScope.irf.containsKey(name)) {
            name = gScope.irf.get(name);
        } else {
            name = "member_fun." + cur.obj.type.getTypename() + "." + cur.funcName;
        }
        if(cur.type.isVoid()) res = null;
        else res = new reg(name + ".res", toIRType(cur.type));
        call c = new call(res, name);
        c.retType = toIRType(cur.type);
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
        String name = cur.obj.type.getTypename() + "::" + cur.varName;
        reg ptr = new reg(cur.varName, new ptrType(toIRType(currentScope.getVarType(name, null))));
        cur.obj.accept(this);
        cur.obj.isLeft = true;
        curBlock.addInst(new getelementptr(ptr, cur.obj.ent, gScope.irt.get(cur.obj.type.getTypename()), new literalInt(intIR, gScope.getVarIndex(name)), 0));
        cur.ptr = ptr;
        if(!cur.isLeft) {
            reg res = new reg("local_var", toIRType(cur.type));
            curBlock.addInst(new load(toIRType(cur.type), res, ptr));
            cur.ent = res;
            if(cur.type.isBool()) {
                reg rew = new reg("tobool", boolIR);
                curBlock.addInst(new convert(rew, res, boolIR, intIR, convert.conv.TRUNC));
                cur.ent = rew;
            } else {
                cur.ent = res;
            }
        }
    }

    private IRType getArrayIndex(ptrType ptr) {
        if(ptr.dim == 0) return ptr.type;
        else return new ptrType(ptr.type, ptr.dim - 1);
    }

    @Override public void visit(ArrayExpNode cur) {
        cur.array.accept(this);
        cur.index.accept(this);
        entity arr = cur.array.ent;
        IRType tp =  getArrayIndex((ptrType) arr.type);
        reg ptr = new reg("array_idx", arr.type);
        cur.ptr = ptr;
        //curBlock.addInst(new getelementptr(ptr, arr, getArrayIndex(tp), cur.index.ent));
        curBlock.addInst(new getelementptr(ptr, arr, tp, cur.index.ent));
        if(!cur.isLeft) {
            reg res = new reg("array", tp);
            curBlock.addInst(new load(tp, res, ptr));
            if(cur.type.isBool()) {
                reg rew = new reg("tobool", boolIR);
                curBlock.addInst(new convert(rew, res, boolIR, intIR, convert.conv.TRUNC));
                cur.ent = rew;
            } else {
                cur.ent = res;
            }
        }
    }

    @Override public void visit(varExpNode cur) {
        entity v = currentScope.getVarEntity(cur.name);
        boolean isMem = false;
        cur.isSingle = true;
        if(curClass != null && curClass.varDefined(cur.name)) {
            entity This = currentScope.getVarEntity("this");
            String name = curClass.name + "::" + cur.name;
            reg cur_this = new reg("this_ptr", ptrIR);
            curBlock.addInst(new load(ptrIR, cur_this, This));
            IRType tt =  ((ptrType) This.type).type;
            reg res = new reg(cur.name, new ptrType(toIRType(currentScope.getVarType(name, null))));
            curBlock.addInst(new getelementptr(res, cur_this, tt, new literalInt(intIR, gScope.getVarIndex(name)), 0));
            v = res;
            isMem = true;
            cur.isSingle = false;
        }
        cur.ptr = v;
        if(!cur.isLeft) {
            reg res = new reg("local_var", toIRType(cur.type));
            curBlock.addInst(new load(toIRType(cur.type), res, v));
            if(isMem && cur.type.isBool()) {
                reg rew = new reg("tobool", boolIR);
                curBlock.addInst(new convert(rew, res, boolIR, intIR, convert.conv.TRUNC));
                cur.ent = rew;
            } else {
                cur.ent = res;
            }
        }
    }

    public void array_alloc(newTypeNode tp, int d, int len, entity addr) {
        reg siz = new reg("siz", intIR);

        if(d == len) {
            curBlock.addInst(new load(intIR, siz, tp.exprs.get(d).ptr));
            if(d > 0) {
                reg cur_addr = new reg("cur_addr", ptrIR);
                curBlock.addInst(new load(ptrIR, cur_addr, addr));
                addr = cur_addr;
            }
//            IRType typ = len + 1 == tp.dim ? toIRType(gScope.getType_(tp.type, null)) : ptrIR;
            reg res = new reg("new_res", ptrIR);
            call c = new call(res,"array_malloc");
            c.retType = ptrIR;
            c.addParameter(siz);
            curBlock.addInst(c);
            curBlock.addInst(new store(ptrIR, res, addr));

        } else {
            block cond = new block("new_for.cond"), body = new block("new_for.body"), step = new block("new_for.step"), end = new block("new_for.end");
            localVar ind = new localVar("ind", intIR);
            curFunc.entry.addInst(new alloca(intIR, ind));
            curBlock.addInst(new store(intIR, zeroLit, ind));
            curBlock.addInst(new br(cond.L));

            curFunc.addBlock(cond);
            reg condition = new reg("comp", boolIR), i = new reg("id", intIR);
            curBlock = cond;
            curBlock.addInst(new load(intIR, siz, tp.exprs.get(d).ptr));
            curBlock.addInst(new load(intIR, i, ind));
            curBlock.addInst(new icmp(BinaryOperator.LE, i, siz, condition));
            curBlock.addInst(new br(condition, body.L, end.L));

            curFunc.addBlock(body);
            curBlock = body;
            reg array = new reg("array_now", ptrIR), arr_next = new reg("array_next", ptrIR), now_I = new reg("cur_i", intIR);
            localVar curArray = new localVar("curArray", ptrIR);
            curFunc.addVarDef(ptrIR, curArray);
            curBlock.addInst(new load(ptrIR, array, addr));
            curBlock.addInst(new load(intIR, now_I, ind));
            curBlock.addInst(new getelementptr(arr_next, array, ptrIR, now_I));
            curBlock.addInst(new store(ptrIR, arr_next, curArray));
            array_alloc(tp, d + 1, len, curArray);
            curBlock.addInst(new br(step.L));

            curFunc.addBlock(step);
            curBlock = step;
            reg ind_cur = new reg("id", intIR), ind_res = new reg("ind", intIR);
            curBlock.addInst(new load(intIR, ind_cur, ind));
            curBlock.addInst(new arith(BinaryOperator.ADD, ind_cur, oneLit, ind_res));
            curBlock.addInst(new store(intIR, ind_res, ind));
            curBlock.addInst(new br(cond.L));

            curFunc.addBlock(end);
            curBlock = end;
        }
    }

    @Override public void visit(NewExpNode cur) {
        if(cur.tp.dim == 0) {
            IRClass cl = (IRClass) gScope.irt.get(cur.type.toString());
            reg ptr = new reg("ptr", toIRType(cur.type));
            call c = new call(ptr, "class_malloc");
            c.retType = ptrIR;
            c.addParameter(new literalInt(intIR, cl.getBytes()));
            cur.ent = ptr;
            curBlock.addInst(c);
            if(cl.isConstructor()) {
                call cc = new call(null, "constructor." + cl.name);
                cc.retType = voidIR;
                cc.addParameter(cur.ent);
                curBlock.addInst(cc);
            }

//            c.addParameter(new literalInt());
        } else {
            cur.tp.exprs.forEach(e -> {
                e.isLeft = true;
                e.accept(this);
                if(e.ptr == null) {
                    localVar now = new localVar("var.arrsiz", intIR);
//                    curFunc.entry.addInst(new alloca(intIR, now));
                    curFunc.addVarDef(intIR, now);
                    curBlock.addInst(new store(intIR, e.ent, now));
                    e.ptr = now;
                }
            });
            localVar res = new localVar("array_store", ptrIR);
//            curFunc.entry.addInst(new alloca(ptrIR, res));
            curFunc.addVarDef(ptrIR, res);
            array_alloc(cur.tp, 0, 0, res);
            for(int i = 1; i < cur.tp.exprs.size(); ++i) {
                array_alloc(cur.tp, 0, i, res);
            }
            cur.ptr = res;
            if(!cur.isLeft) {
                reg now = new reg("var.res", ptrIR);
                curBlock.addInst(new load(ptrIR, now, res));
                cur.ent = now;
            }
        }
    }

    @Override public void visit(constExprNode cur) {
        if(cur.type.isInt()) {
            cur.ent = new literalInt(intIR, ((IntNode) cur).value);
        } else if(cur.type.isBool()) {
            cur.ent = new literalBool(boolIR, ((BoolNode) cur).value);
        } else if(cur.type.isNull()) {
            cur.ent = nullLit;
        } else if(cur.type.isString()) {
            literalStr str = new literalStr(strIR, ((StringNode) cur).value);
            topModule.str.add(str);
            cur.ent = str;
//            cur.ent = new globalVar()
//            topModule
            //cur.ent = new literalStr(strIR, ((StringNode) cur).value);
        }
    }

    @Override public void visit(ThisNode cur) {
        entity This = currentScope.getVarEntity("this");
        cur.ptr = This;
        if(!cur.isLeft) {
            reg res = new reg("this_ptr", This.type);
            curBlock.addInst(new load(This.type, res, This));
            cur.ent = res;
        }
    }
}
