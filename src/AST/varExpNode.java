package AST;

import Util.Type;
import Util.position;

public class varExpNode extends exprNode{
    String name;
    public varExpNode(String id, position p) {
        super(p, null);
        name = id;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }

    @Override public boolean isAssign() {return true;}
}
