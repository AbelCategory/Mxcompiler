package AST;

import Util.Type;
import Util.position;

public class condExpNode extends exprNode {
    public exprNode cond, exp1, exp2;

    public condExpNode(exprNode c, exprNode e1, exprNode e2, position p, Type type) {
        super(p, type);
        cond = c;
        exp1 = e1;
        exp2 = e2;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
