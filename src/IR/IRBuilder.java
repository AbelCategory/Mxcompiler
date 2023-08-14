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
    public I_Type boolIR = new I_Type(8);
    public ptrType ptrIR = new ptrType(null);
    public IRString strIR = new IRString();
    public I_Type I_1 = new I_Type(1);
    public null_Type nullIR = new null_Type();
    public literalNull nullLit = new literalNull(nullIR);
    public literalBool falseLit = new literalBool(boolIR, false);
    public literalBool trueLit = new literalBool(boolIR, true);

    public IRBuilder(globalScope gScope) {
        this.gScope = gScope;
    }

    public IRType toIRType(Type t) {
        IRType tp;
        Type d = t.isArray() ? t : ((ArrayType) t).type;
        if(d.isInt()) {
            tp = intIR;
        } else if(d.isVoid()) {
            tp = voidIR;
        } else if(d.isBool()) {
            tp = boolIR;
        } else if(d.isString()) {
            tp = strIR;
        } else {
            tp = null;
        }
        if(t.isArray()) {
            tp = new ptrType(tp, ((ArrayType) t).dim);
        }
        return tp;
    }

    @Override public void visit(rtNode cur) {
        currentScope = gScope;
        gVarInit = new IRFunc("__cxx_global_var_init", voidIR);
        cur.def.forEach(x -> x.accept(this));
    }

    @Override public void visit(classNode cur) {}

    @Override public void visit(funcNode cur) {
        IRFunc fun = new IRFunc(cur.name, toIRType(gScope.getType(cur.tp, null)));
        currentScope = new Scope(currentScope);
        cur.pa.forEach(p -> {
            IRType tp = toIRType(gScope.getType(cur.tp, null));
            reg par = new reg(p.name, tp);
            fun.addAugment(par);
            localVar res = new localVar(p.name + ".addr", tp);
            fun.suite.get(0).addInst(new store(tp, par, res));
        });
        cur.body.stats.forEach(s -> s.accept(this));
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
        cur.var.forEach(v -> {
            IRType type = toIRType(gScope.getType(cur.type, null));
            globalVar w = new globalVar(v.name, new ptrType(type));
            if(v.body != null) {
                v.body.accept(this);
            }
        });
    }

    public void visitLocalVar(varDefNode cur) {
        cur.var.forEach(v -> {
            IRType type = toIRType(gScope.getType(cur.type, null));
            localVar w = new localVar(v.name, new ptrType(type));
            if(v.body != null) {
                v.body.accept(this);

            }
        });
    }

    @Override public void visit(BlockStatNode cur) {}
    @Override public void visit(IfStatNode cur) {}
    @Override public void visit(ForDefStatNode cur) {}
    @Override public void visit(ForExpStatNode cur) {}
    @Override public void visit(WhileStatNode cur) {}
    @Override public void visit(breakStatNode cur) {}

    @Override public void visit(continueStatNode cur) {}

    @Override public void visit(returnStatNode cur) {}

    @Override public void visit(exprStatNode cur) {}

    @Override public void visit(binaryExpNode cur) {
        switch (cur.op) {
            case EQ, NEQ, LE, GR, LEQ, GEQ -> {
                cur.lhs.accept(this);
                cur.rhs.accept(this);
                reg res = new reg(cur.op.toString().toLowerCase(), boolIR);
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
                reg res = new reg("frombool", intIR);
                reg tr1 = new reg("tobool", I_1);
                block pre = curBlock, block1 = new block(cur.op.toString().toLowerCase() + ".rhs");
                block block2 = new block(cur.op.toString().toLowerCase() + ".end");
                cur.lhs.accept(this);
                if(cur.lhs.ent instanceof literalBool) {
                    literalBool lhs = (literalBool) cur.lhs.ent;
                    if(lhs.val == (cur.op == BinaryOperator.LOR)) {
                        cur.ent = lhs;
                    } else {
                        cur.ent = cur.rhs.ent;
                    }
                    return;
                }
                reg zext = new reg("zero_ext", I_1);
                phi P = new phi(zext);
                if (cur.op == BinaryOperator.LAND) {
                    pre.addInst(new convert(tr1, cur.lhs.ent, I_1, boolIR, convert.conv.TRUNC));
                    pre.addInst(new br(res, block1.L, block2.L));
                    curBlock = block1;
                    cur.rhs.accept(this);
                    reg tr2 = new reg("tobool", I_1);
                    curBlock.addInst(new convert(tr2, cur.rhs.ent, I_1, boolIR, convert.conv.TRUNC));
                    curBlock = block2;
                    P.addVal(pre.L, falseLit);
                    P.addVal(block1.L, tr2);
                    curBlock.addInst(P);
                    curBlock.addInst(new convert(res, zext, boolIR, I_1, convert.conv.ZEXT));
                } else {
                    pre.addInst(new convert(tr1, cur.lhs.ent, I_1, boolIR, convert.conv.TRUNC));
                    pre.addInst(new br(res, block2.L, block1.L));
                    curBlock = block1;
                    cur.rhs.accept(this);
                    reg tr2 = new reg("tobool", I_1);
                    curBlock.addInst(new convert(tr2, cur.rhs.ent, I_1, boolIR, convert.conv.TRUNC));
                    curBlock = block2;
                    P.addVal(pre.L, trueLit);
                    P.addVal(block2.L, tr2);
                    curBlock.addInst(P);
                    curBlock.addInst(new convert(res, zext, boolIR, I_1, convert.conv.ZEXT));
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
        curBlock.addInst(new store(intIR, res, cur.e.ent));
        cur.ent = cur.e.ent;
    }

    @Override public void visit(preUpdateExpNode cur) {
        cur.e.accept(this);
        reg res = new reg(cur.op.toString().toLowerCase(), intIR);
        BinaryOperator op = cur.op == UPDOperator.INC ? BinaryOperator.ADD : BinaryOperator.SUB;
        curBlock.addInst(new arith(op, cur.e.ent, new literalInt(intIR, 1), res));
        curBlock.addInst(new store(intIR, res, cur.e.ent));
        cur.ent = res;
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
            }
        }
    }

    @Override public void visit(assignNode cur) {
        cur.rhs.accept(this);
        cur.lhs.accept(this);
        curBlock.addInst(new store(toIRType(cur.lhs.type), cur.rhs.ent, cur.lhs.ent));
        cur.ent = cur.rhs.ent;
    }

    @Override public void visit(funCallNode cur) {
        reg res;
        if(cur.type.isVoid()) res = null;
        else res = new reg(cur.funcName + ".res", toIRType(cur.type));
        call c = new call(res, cur.funcName);
        cur.arguments.forEach(p -> {
            p.accept(this);
            c.addParameter(p.ent);
        });
        curBlock.addInst(c);
        cur.ent = res;
    }

    @Override public void visit(memberFuncNode cur) {}

    @Override public void visit(memberVarNode cur) {}

    @Override public void visit(ArrayExpNode cur) {}

    @Override public void visit(varExpNode cur) {
        reg res = new reg("local_var", toIRType(cur.type));
        entity var = currentScope.getVarEntity(cur.name);
        curBlock.addInst(new load(toIRType(cur.type), res, var));
        cur.ent = res;
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
