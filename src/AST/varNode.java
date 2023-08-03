package AST;

import Util.position;

public class varNode extends ASTNode{
    public String name;
    public exprNode body;
    public varNode(String id, exprNode body, position p) {
        super(p);
        name = id;
        this.body = body;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
