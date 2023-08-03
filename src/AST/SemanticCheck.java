package AST;

import Util.*;

public class SemanticCheck implements ASTVistor {
    globalScope gScope;
    Scope currentScope;
    public SemanticCheck(globalScope gScope) {
        this.gScope = gScope;
    }

    @Override public void visit(rtNode cur) {
        cur.mainFn.accept(this);
    }

    @Override public void visit(funcNode cur) {

        cur.body.accept(this);
    }

    @Override public void visit(classNode cur) {
        for()
    }
}
