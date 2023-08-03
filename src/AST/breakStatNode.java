package AST;

import Util.position;

public class breakStatNode extends ControlNode {
    public breakStatNode(position p) {
        super(p);
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
