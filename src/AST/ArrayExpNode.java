package AST;

import Util.Type;
import Util.position;

public class ArrayExpNode extends exprNode {
    public exprNode array, index;
    public ArrayExpNode(exprNode a, exprNode i, position p, Type type) {
        super(p, type);
        array = a;
        index = i;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
