package IR;

import AST.*;
import Util.*;

import AST.ASTVistor;

public class IRBuilder implements ASTVistor {
    public globalScope gScope;
    public IRFunc gVarInit;
    public Scope currentScope;
    public voidType voidIR = new voidType();

    public IRBuilder(globalScope gScope) {
        this.gScope = gScope;
    }

    @Override public void visit(rtNode cur) {
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

    public void visitGlobalVar(varDefNode cur) {
        cur.var.forEach(v -> {
            globalVar w = new globalVar(v.name, );

        });
    }

    public void visitLocalVar(varDefNode cur) {

    }
}
