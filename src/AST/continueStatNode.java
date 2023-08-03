package AST;

import Util.position;

public class continueStatNode extends ControlNode {
    public continueStatNode(position p) {
        super(p);
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
