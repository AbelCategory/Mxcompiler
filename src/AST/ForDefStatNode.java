package AST;

import Util.position;

public class ForDefStatNode extends ForStatNode {
    public varDefNode init;
    public ForDefStatNode(varDefNode init, exprNode cond, exprNode step, StatNode s, position p) {
        super(cond, step, s, p);
        this.init = init;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
