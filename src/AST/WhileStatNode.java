package AST;

import Util.position;

public class WhileStatNode extends LoopStatNode {
    public exprNode cond;

    public WhileStatNode(exprNode cond, StatNode body, position p) {
        super(p, body);
        this.cond = cond;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
