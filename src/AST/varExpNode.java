package AST;

import IR.entity;
import Util.position;

public class varExpNode extends exprNode{
    public String name;
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
