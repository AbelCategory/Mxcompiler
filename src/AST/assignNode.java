package AST;

import Util.Type;
import Util.position;

public class assignNode extends exprNode {
    public exprNode lhs, rhs;
    public assignNode(exprNode lh, exprNode rh, position p, Type type) {
        super(p, type);
        lhs = lh;
        rhs = rh;
    }
    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
