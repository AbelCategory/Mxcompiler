package AST;

import Util.position;

public class returnStatNode extends ControlNode {
    public exprNode expr;
    public returnStatNode(exprNode expr, position p) {
        super(p);
        this.expr = expr;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
