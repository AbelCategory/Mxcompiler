package AST;

import Util.*;
import Error.semanticError;

public class SymbolCollector implements ASTVistor {
    private globalScope gScope;
    public SymbolCollector(globalScope gsp) {
        gScope = gsp;
    }
    @Override public void visit(rtNode cur) {
        cur.classDef.forEach(c -> c.accept(this));
        cur.funcDef.forEach(f -> f.accept(this));
        cur.mainFn.accept(this);
        cur.classDef.forEach(this::visitMem);
//        cur.classDef.forEach(c -> check(c));
    }

    private void visitMem(classNode c) {
        c.funcDef.forEach(f -> visitFunMem(c, f));
        c.varDef.forEach(v -> visitVarMem(c, v));
        if(c.constructor != null) {
//            c.constructor.tp =
        }
    }

    private void visitFunMem(classNode c, funcNode f) {
        String name = c.name + "::" + f.name;
//        gScope.newFunc(c.name + "::" + f.name, );
        FuncType func = new FuncType(f.name, gScope.getType(f.tp, f.pos));
        f.pa.forEach(aug -> func.paraType.add(gScope.getType(aug.type, aug.p)));
        gScope.newFunc(name, func, f.pos);
    }

    private void visitVarMem(classNode c, varDefNode v) {
        Type type = gScope.getType(v.type, v.pos);
        v.var.forEach(var -> gScope.newVariable(c.name + "::" + var.name, type, var.pos));
    }


    @Override public void visit(classNode cur) {
        if(cur.name.equals("main")) {
            throw new semanticError("class name cannot be main", cur.pos);
        }
        ClassType cl = new ClassType(cur.name);
        cur.varDef.forEach(v -> v.accept(this));
        gScope.newType(cur.name, cl, cur.pos);
    }

    @Override public void visit(funcNode cur) {
        if(gScope.typeDefined(cur.name)) {
            throw new semanticError("function name and typename coincide", cur.pos);
        }
        FuncType func = new FuncType(cur.name, gScope.getType(cur.tp, cur.pos));
        cur.pa.forEach(aug -> func.paraType.add(gScope.getType(aug.type, aug.p)));
        gScope.newFunc(cur.name, func, cur.pos);
//        cur.pa.forEach(aug -> check(aug));
    }

    @Override public void visit(varDefNode cur) {}
    @Override public void visit(varNode cur) {}

    @Override public void visit(BlockStatNode cur) {}
    @Override public void visit(IfStatNode cur) {}
    @Override public void visit(ForDefStatNode cur) {}
    @Override public void visit(ForExpStatNode cur) {}
    @Override public void visit(WhileStatNode cur) {}
    @Override public void visit(breakStatNode cur) {}
    @Override public void visit(continueStatNode cur) {}
    @Override public void visit(returnStatNode cur) {}
    @Override public void visit(exprStatNode cur) {}

    @Override public void visit(binaryExpNode cur) {}
    @Override public void visit(unaryExpNode cur) {}
    @Override public void visit(postUpdateExpNode cur) {}
    @Override public void visit(preUpdateExpNode cur) {}
    @Override public void visit(condExpNode cur) {}
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
