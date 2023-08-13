package AST;

import Util.position;
import Util.Type;

public class unaryExpNode extends exprNode {
    public exprNode e;

    public UnaryOperator op;

    unaryExpNode(exprNode exp, UnaryOperator opt, position p, Type type) {
        super(p, type);
        op = opt;
        e = exp;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
