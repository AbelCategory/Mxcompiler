package AST;

import Util.position;
import Util.Type;

public class binaryExpNode extends exprNode {
    public exprNode lhs, rhs;

    public BinaryOperator op;
    public binaryExpNode(exprNode ls, exprNode rs, BinaryOperator opt, position p, Type type) {
        super(p, type);
        lhs = ls;
        rhs = rs;
        op = opt;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
