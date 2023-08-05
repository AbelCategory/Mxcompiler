package AST;

import Util.*;
import Error.semanticError;

public class SemanticCheck implements ASTVistor {
    public globalScope gScope;
    private Scope currentScope;
    private Type currentType = null;
    Type booltype, inttype, stringtype;

    private String classMember(Type a, String b) {
        return a.getTypename() + "::" + b;
    }

    public SemanticCheck(globalScope gScope) {
        this.gScope = gScope;
        booltype = gScope.getType_("bool", null);
        inttype = gScope.getType_("int", null);
        stringtype = gScope.getType_("string", null);
//        nullType = gScope.getType_("null", null);
    }

    @Override public void visit(rtNode cur) {
        currentScope = gScope;
//        cur.funcDef.forEach(f -> f.accept(this));
//        cur.classDef.forEach(c -> c.accept(this));
//        cur.varDef.forEach(v -> v.accept(this));
        cur.def.forEach(d -> d.accept(this));
//        cur.mainFn.accept(this);
    }

    @Override public void visit(funcNode cur) {
        currentScope = new Scope(currentScope);
        currentScope.isFunc = true;
        currentScope.funcReturnType = gScope.getType(cur.tp, cur.pos);
        cur.pa.forEach(v -> currentScope.newVariable(v.name, gScope.getType(v.type, v.p), v.p));
        cur.body.accept(this);
        currentScope = currentScope.getParentScope();
    }

    @Override public void visit(classNode cur) {
        currentScope = new Scope(currentScope);
        currentScope.isClass = true;
        currentScope.thisClassType = gScope.getType_(cur.name, cur.pos);
//        if(cur.constructor != null){
//            cur.constructor.accept(this);
//        }
//        cur.funcDef.forEach(f -> f.accept(this));
//        cur.varDef.forEach(v -> v.accept(this));
        cur.cdef.forEach(c -> c.accept(this));
        currentScope = currentScope.getParentScope();
    }

    @Override public void visit(varDefNode cur) {
        currentType = gScope.getType(cur.type, cur.pos);
        cur.var.forEach(v -> v.accept(this));
    }

    @Override public void visit(varNode cur) {
        if(gScope.funcDefined(cur.name)) {
            throw new semanticError("variable name and function name coincide", cur.pos);
        }
        if(cur.body != null) {
            cur.body.accept(this);
        }
        if(cur.body != null) {
            if(cur.body.type.isNull()) {
                if(!currentType.isClass() && !currentType.isArray()) {
                    throw new semanticError("assign a null to basic type variable " + cur.name, cur.pos);
                }
            } else {
                if(!cur.body.type.equal(currentType)) {
                    throw new semanticError("Type not match the definition of " + cur.name, cur.pos);
                }
            }
        }
        currentScope.newVariable(cur.name, currentType, cur.pos);
    }

    @Override public void visit(BlockStatNode cur) {
        currentScope = new Scope(currentScope);
        cur.stats.forEach(st -> st.accept(this));
        currentScope = currentScope.getParentScope();
    }

    @Override public void visit(IfStatNode cur) {
        cur.cond.accept(this);
        if(!cur.cond.type.isBool()) {
            throw new semanticError("if condition not a bool", cur.cond.pos);
        }
        cur.thenStat.accept(this);
        if(cur.elseStat != null){
            cur.elseStat.accept(this);
        }
    }

    @Override public void visit(ForDefStatNode cur) {
        currentScope = new Scope(currentScope);
        currentScope.isLoop = true;
        if(cur.init != null) {
            cur.init.accept(this);
        }
        if(cur.cond != null) {
            cur.cond.accept(this);
            if(!cur.cond.type.isBool()) {
                throw new semanticError("for condition not a bool", cur.cond.pos);
            }
        }
        if(cur.step != null) {
            cur.step.accept(this);
        }
        cur.body.accept(this);
        currentScope = currentScope.getParentScope();
    }

    @Override public void visit(ForExpStatNode cur) {
        currentScope = new Scope(currentScope);
        currentScope.isLoop = true;
        if(cur.init != null) {
            cur.init.accept(this);
        }
        if(cur.cond != null) {
            cur.cond.accept(this);
            if(!cur.cond.type.isBool()) {
                throw new semanticError("for condition not a bool", cur.cond.pos);
            }
        }
        if(cur.step != null) {
            cur.step.accept(this);
        }
        cur.body.accept(this);
        currentScope = currentScope.getParentScope();
    }

    @Override public void visit(WhileStatNode cur) {
        currentScope = new Scope(currentScope);
        currentScope.isLoop = true;
        cur.cond.accept(this);
        if(!cur.cond.type.isBool()) {
            throw new semanticError("while condition not a bool", cur.cond.pos);
        }
        cur.body.accept(this);
        currentScope = currentScope.getParentScope();
    }

    @Override public void visit(breakStatNode cur) {
        if(!currentScope.isInLoop()) {
            throw new semanticError("break in no loop", cur.pos);
        }
    }

    @Override public void visit(continueStatNode cur) {
        if(!currentScope.isInLoop()) {
            throw new semanticError("continue in no loop", cur.pos);
        }
    }

    @Override public void visit(returnStatNode cur) {
        if(!currentScope.isInFunc()) {
            throw new semanticError("return in not function", cur.pos);
        }
        if(cur.expr == null) {
            if(!currentScope.getFuncReturnType().isVoid()) {
                throw new semanticError("ths function should be void", cur.pos);
            }
        } else {
            cur.expr.accept(this);
            if (!cur.expr.type.equal(currentScope.getFuncReturnType())) {
                throw new semanticError("return type not matched", cur.pos);
            }
        }
    }

    @Override public void visit(exprStatNode cur) {
        cur.expr.accept(this);
    }


    @Override public void visit(binaryExpNode cur) {
        cur.lhs.accept(this);
        cur.rhs.accept(this);
        if((cur.op == BinaryOperator.EQ || cur.op == BinaryOperator.NEQ) && (cur.lhs.type.isNull() || cur.rhs.type.isNull())) {
            if(cur.lhs.type.isNull() && (cur.rhs.type.isNull() || cur.rhs.type.isArray() && cur.rhs.arrayOk || cur.rhs.type.isClass())) {
                cur.type = booltype;
                return;
            }
            if(cur.rhs.type.isNull() && (cur.lhs.type.isNull() || cur.lhs.type.isArray() && cur.lhs.arrayOk || cur.lhs.type.isClass())) {
                cur.type = booltype;
                return;
            }
            throw new semanticError("wrong compare null", cur.pos);
        }
        if(!cur.lhs.type.equal(cur.rhs.type)) {
            throw new semanticError("type not matched", cur.pos);
        }
        if(cur.lhs.type.isInt()) {
            switch (cur.op) {
                case LAND, LOR -> throw new semanticError("logical operator on two int", cur.pos);
                case EQ, NEQ, LE, GR, LEQ, GEQ -> cur.type = booltype;
                default -> cur.type = inttype;
            }
        } else if(cur.lhs.type.isBool()) {
            switch (cur.op) {
                case EQ, NEQ, LAND, LOR -> cur.type = booltype;
                default -> throw new semanticError("arithmetic operator on two bool", cur.pos);
            }
        } else if(cur.lhs.type.isString()) {
            switch (cur.op) {
                case ADD -> cur.type = stringtype;
                case EQ, NEQ, LE, GR, LEQ, GEQ -> cur.type = booltype;
                default -> throw new semanticError("wrong operator on two string", cur.pos);
            }
        } else {
            throw new semanticError("wrong binary expression type", cur.pos);
        }
    }

    @Override public void visit(unaryExpNode cur) {
        cur.e.accept(this);
        if(cur.e.type.isInt()) {
            if(cur.op == UnaryOperator.LNOT) {
                throw new semanticError("logical not on int", cur.pos);
            }
            cur.type = inttype;
        } else if(cur.e.type.isBool()) {
            if(cur.op != UnaryOperator.LNOT) {
                throw new semanticError("arithmetic operator on bool", cur.pos);
            }
            cur.type = booltype;
        } else {
            throw new semanticError("wrong unary expression type", cur.pos);
        }
    }

    @Override public void visit(postUpdateExpNode cur) {
        cur.e.accept(this);
        if(!cur.e.isAssign()) {
            throw new semanticError("update operator on not assignable expression", cur.pos);
        }
        if(!cur.e.type.isInt()) {
            throw new semanticError("update operator on not int", cur.pos);
        }
        cur.type = inttype;
    }

    @Override public void visit(preUpdateExpNode cur) {
        cur.e.accept(this);
        if(!cur.e.isAssign()) {
            throw new semanticError("update operator on not assignable expression", cur.pos);
        }
        if(!cur.e.type.isInt()) {
            throw new semanticError("update operator on not int", cur.pos);
        }
        cur.type = inttype;
    }

    @Override public void visit(condExpNode cur) {
        cur.cond.accept(this);
        if(!cur.cond.type.isBool()) {
            throw new semanticError("condition not a bool", cur.pos);
        }
        cur.exp1.accept(this);
        cur.exp2.accept(this);
        if(!cur.exp1.type.equal(cur.exp2.type)) {
            throw new semanticError("expression type not match", cur.pos);
        }
        cur.type = cur.exp1.type;
    }

    @Override public void visit(assignNode cur) {
        cur.lhs.accept(this);
        cur.rhs.accept(this);
        if(!cur.lhs.isAssign()) {
            throw new semanticError("left hand side is not assignable", cur.pos);
        }
        if(cur.rhs.type.isNull()) {
            if(!cur.lhs.type.isArray() && !cur.lhs.type.isClass()) {
                throw new semanticError("assign a null to a basic type", cur.pos);
            }
        } else if(!cur.lhs.type.equal(cur.rhs.type)) {
            throw new semanticError("type not match on two side of equation", cur.pos);
        }
        cur.type = cur.lhs.type;
    }

    @Override public void visit(funCallNode cur) {
        FuncType fun;
        if(gScope.funcDefined(cur.funcName)) {
            fun = gScope.getFunc(cur.funcName, cur.pos);
        } else if(currentScope.isInClass() && gScope.funcDefined(classMember(currentScope.getThisClassType(), cur.funcName))) {
            fun = gScope.getFunc(classMember(currentScope.getThisClassType(), cur.funcName), cur.pos);
        } else {
            throw new semanticError("no such function", cur.pos);
        }
        if(fun.paraType.size() != cur.arguments.size()) {
            throw new semanticError("arguments number not matched", cur.pos);
        }
        int n = fun.paraType.size();
        for(int i = 0; i < n; ++i) {
            exprNode now = cur.arguments.get(i);
            now.accept(this);
            if(!fun.paraType.get(i).equal(now.type)) {
                throw new semanticError("arguments type not match", now.pos);
            }
        }
        cur.type = fun.returnType;
    }

    @Override public void visit(memberFuncNode cur) {
        cur.obj.accept(this);
        Type t = cur.obj.type;
        String cla = t.getTypename();
        FuncType fun = gScope.getFunc(cla + "::" + cur.funcName, cur.pos);
        if(fun.paraType.size() != cur.arguments.size()) {
            throw new semanticError("arguments number not matched", cur.pos);
        }
        int n = fun.paraType.size();
        for(int i = 0; i < n; ++i) {
            exprNode now = cur.arguments.get(i);
            now.accept(this);
            if(!fun.paraType.get(i).equal(now.type)) {
                throw new semanticError("arguments type not match", now.pos);
            }
        }
        cur.type = fun.returnType;
    }

    @Override public void visit(memberVarNode cur) {
        cur.obj.accept(this);
        Type t = cur.obj.type;
        String cla = t.getTypename();
        cur.type = gScope.getVarType(cla + "::" + cur.varName, cur.pos);
    }

    @Override public void visit(ArrayExpNode cur) {
        cur.array.accept(this);
        if(!cur.array.type.isArray() || !cur.array.isAssign() && !cur.array.arrayOk) {
            throw new semanticError("try to visit index of not array", cur.pos);
        }
        cur.index.accept(this);
        if(!cur.index.type.isInt()) {
            throw new semanticError("index not an int", cur.pos);
        }
        cur.type = ((ArrayType) cur.array.type).index();
    }

    @Override public void visit(varExpNode cur) {
        if(currentScope.variableDefined(cur.name)) {
            cur.type = currentScope.getVarType(cur.name, cur.pos);
        } else if(currentScope.isInClass() && gScope.variableDefined(classMember(currentScope.getThisClassType(), cur.name))){
            cur.type = gScope.getVarType(classMember(currentScope.getThisClassType(), cur.name), cur.pos);
        } else {
            throw new semanticError("no such variable", cur.pos);
        }
    }

    @Override public void visit(NewExpNode cur) {
        if(cur.tp.dim != 0) {
            cur.tp.exprs.forEach(e -> e.accept(this));
            cur.tp.exprs.forEach(e -> {
                if(!e.type.isInt()) throw new semanticError("new array index not int", e.pos);
            });
        }
        cur.type = gScope.getType(cur.typ, cur.pos);
    }

    @Override public void visit(constExprNode cur) {}

    @Override public void visit(ThisNode cur) {
        if(!currentScope.isInClass()) {
            throw new semanticError("this pointer not in a class", cur.pos);
        }
        cur.type = currentScope.getThisClassType();
    }
}
