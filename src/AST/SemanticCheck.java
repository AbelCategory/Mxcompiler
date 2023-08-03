package AST;

import Util.*;
import Error.semanticError;

public class SemanticCheck implements ASTVistor {
    public globalScope gScope;
    private Scope currentScope;
    private Type currentType = null;
    public SemanticCheck(globalScope gScope) {
        this.gScope = gScope;
    }

    @Override public void visit(rtNode cur) {
        currentScope = gScope;
        cur.funcDef.forEach(f -> f.accept(this));
        cur.classDef.forEach(c -> c.accept(this));
        cur.varDef.forEach(v -> v.accept(this));
        cur.mainFn.accept(this);
    }

    @Override public void visit(funcNode cur) {
        currentScope = new Scope(currentScope);
        cur.pa.forEach(v -> currentScope.newVariable(v.name, gScope.getType(v.type, v.p), v.p));
        cur.body.accept(this);
        currentScope = currentScope.getParentScope();
    }

    @Override public void visit(classNode cur) {
        currentScope = new Scope(currentScope);
        cur.funcDef.forEach(f -> f.accept(this));
        cur.varDef.forEach(v -> v.accept(this));
        currentScope = currentScope.getParentScope();
    }

    @Override public void visit(varDefNode cur) {
        currentType = gScope.getType(cur.type, cur.pos);
        cur.var.forEach(v -> v.accept(this));
    }

    @Override public void visit(varNode cur) {
        cur.body.accept(this);
        if(!cur.body.type.equal(currentType)) {
            throw new semanticError("Type not match the defintion of " + cur.name, cur.pos);
        }
    }

    @Override public void visit(BlockStatNode cur) {
        currentScope = new Scope(currentScope);
        cur.stats.forEach(st -> st.accept(this));
        currentScope = currentScope.getParentScope();
    }

    @Override public void visit(IfStatNode cur) {
        cur.cond.accept(this);
        cur.thenStat.accept(this);
        if(cur.elseStat != null){
            cur.elseStat.accept(this);
        }
    }

    @Override public void visit(ForDefStatNode cur) {
        currentScope = new Scope(currentScope);
        if(cur.init != null) {
            cur.init.accept(this);
        }
        if(cur.cond != null) {
            cur.cond.accept(this);
        }
        if(cur.step != null) {
            cur.step.accept(this);
        }
        cur.body.accept(this);
        currentScope = currentScope.getParentScope();
    }

    @Override public void visit(ForExpStatNode cur) {
        if(cur.init != null) {
            cur.init.accept(this);
        }
        if(cur.cond != null) {
            cur.cond.accept(this);
        }
        if(cur.step != null) {
            cur.step.accept(this);
        }
        cur.body.accept(this);
    }

    @Override public void visit(WhileStatNode cur) {
        cur.cond.accept(this);
        cur.body.accept(this);
    }

    @Override public void visit(breakStatNode cur) {
        if(!currentScope.isInLoop())
            throw new semanticError("break in no loop", cur.pos);
    }

    @Override public void visit(continueStatNode cur) {
        if(!currentScope.isInLoop())
            throw new semanticError("continue in no loop", cur.pos);
    }

    @Override public void visit(returnStatNode cur) {
        if(!currentScope.isInFunc())
            throw new semanticError("return in not function", cur.pos);
        cur.expr.accept(this);
    }

    @Override public void visit(exprStatNode cur) {
        cur.expr.accept(this);
    }


    @Override public void visit(binaryExpNode cur) {

    }
}
