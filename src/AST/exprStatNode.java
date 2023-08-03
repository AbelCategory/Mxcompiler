package AST;

import Util.position;

public class exprStatNode extends StatNode {
    public exprNode expr;

    public exprStatNode(exprNode expr, position p) {
        super(p);
        this.expr = expr;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
