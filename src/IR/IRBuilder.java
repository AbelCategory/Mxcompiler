package IR;

import AST.*;
import Util.*;

import AST.ASTVistor;

public class IRBuilder implements ASTVistor {
    public globalScope gScope;
    public IRFunc gVarInit;
    public Scope currentScope;
    public voidType voidIR = new voidType();
    public I_Type intIR = new I_Type(32);
    public I_Type boolIR = new I_Type(1);
    public ptrType ptrIR = new ptrType(null);
    public IRString strIR = new IRString();

    public IRBuilder(globalScope gScope) {
        this.gScope = gScope;
    }

    public IRType toIRType(typeNode t) {
        IRType tp;
        switch (t.type) {
            case "int" -> tp = intIR;
            case "bool" -> tp = boolIR;
            case "void" -> tp = voidIR;
            case "string" -> tp = strIR;
            default -> tp = null;
        }
        if(t.isArray()) {
            tp = new ptrType(tp, ((typeArrayNode) t).dim);
        }
        return tp;
//        return ptrIR;
    }

    @Override public void visit(rtNode cur) {
        currentScope = gScope;
        gVarInit = new IRFunc("__cxx_global_var_init", voidIR);
        cur.def.forEach(x -> x.accept(this));
    }

    @Override public void visit(classNode cur) {}

    @Override public void visit(funcNode cur) {

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
            IRType type = toIRType(cur.type);
            globalVar w = new globalVar(v.name, new ptrType(type));
            if(v.body != null) {
                v.body.accept(this);
            }
        });
    }

    public void visitLocalVar(varDefNode cur) {
        cur.var.forEach(v -> {
            IRType type = toIRType(cur.type);
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
        cur.lhs.accept(this);
        cur.rhs.accept(this);
        if((cur.lhs.ent instanceof literal) && (cur.rhs.ent instanceof literal)) {
            switch (cur.op) {
                case ADD -> {
                    if(cur.lhs.ent instanceof literalInt) {
                        cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val + ((literalInt) cur.rhs.ent).val);
                    }
                }
                case SUB -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val - ((literalInt) cur.rhs.ent).val);
                case MUL -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val * ((literalInt) cur.rhs.ent).val);
                case DIV -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val / ((literalInt) cur.rhs.ent).val);
                case MOD -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val % ((literalInt) cur.rhs.ent).val);

                case EQ -> {
//                    if(cur.lhs.ent instanceof
                    if(cur.lhs.ent instanceof literalInt) {
                        cur.ent = new literalBool((boolIR), ((literalInt) cur.lhs.ent).val == ((literalInt) cur.rhs.ent).val);
                    }
                }
                case NEQ -> {
                    if(cur.lhs.ent instanceof literalInt) {
                        cur.ent = new literalBool((boolIR), ((literalInt) cur.lhs.ent).val != ((literalInt) cur.rhs.ent).val);
                    }
                }
                case LE -> {
                    if(cur.lhs.ent instanceof literalInt) {
                        cur.ent = new literalBool((boolIR), ((literalInt) cur.lhs.ent).val < ((literalInt) cur.rhs.ent).val);
                    }
                }
                case GR -> {
                    if(cur.lhs.ent instanceof literalInt) {
                        cur.ent = new literalBool((boolIR), ((literalInt) cur.lhs.ent).val > ((literalInt) cur.rhs.ent).val);
                    }
                }
                case LEQ -> {
                    if(cur.lhs.ent instanceof literalInt) {
                        cur.ent = new literalBool((boolIR), ((literalInt) cur.lhs.ent).val <= ((literalInt) cur.rhs.ent).val);
                    }
                }
                case GEQ -> {
                    if(cur.lhs.ent instanceof literalInt) {
                        cur.ent = new literalBool((boolIR), ((literalInt) cur.lhs.ent).val >= ((literalInt) cur.rhs.ent).val);
                    }
                }

                case BAND -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val & ((literalInt) cur.rhs.ent).val);
                case BOR -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val | ((literalInt) cur.rhs.ent).val);
                case BXOR -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val ^ ((literalInt) cur.rhs.ent).val);
                case LSH -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val << ((literalInt) cur.rhs.ent).val);
                case RSH -> cur.ent = new literalInt(intIR, ((literalInt) cur.lhs.ent).val >> ((literalInt) cur.rhs.ent).val);

                case LAND -> cur.ent = new literalBool(boolIR, ((literalBool) cur.lhs.ent).val && ((literalBool) cur.rhs.ent).val);
                case LOR -> cur.ent = new literalBool(boolIR, ((literalBool) cur.lhs.ent).val || ((literalBool) cur.rhs.ent).val);
            }
        } else {
            switch (cur.op) {
                case EQ, NEQ, LE, GR, LEQ, GEQ -> {
                    icmp now = new icmp(cur.op, cur.lhs.ent, cur.rhs.ent, cur.ent);
                }
                case ADD, SUB, MUL, DIV, MOD, BAND, BOR, BXOR -> {
                    arith now = new arith(cur.op, cur.lhs.ent, cur.rhs.ent, cur.ent);
                }

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

        }
    }

    @Override public void visit(postUpdateExpNode cur) {

    }

    @Override public void visit(preUpdateExpNode cur) {
        cur.e.accept(this);

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
            cur.exp1.accept(this);
            cur.exp1.accept(this);
        }
    }

    @Override public void visit(assignNode cur) {}

    @Override public void visit(funCallNode cur) {}

    @Override public void visit(memberFuncNode cur) {}

    @Override public void visit(memberVarNode cur) {}

    @Override public void visit(ArrayExpNode cur) {}

    @Override public void visit(varExpNode cur) {}

    @Override public void visit(NewExpNode cur) {}

    @Override public void visit(constExprNode cur) {}

    @Override public void visit(ThisNode cur) {}
}
