package AST;

import Util.Type;
import Util.position;

public abstract class updateExpNode extends exprNode {
    public exprNode e;
    UPDOperator op;
    public updateExpNode(exprNode exp, UPDOperator opt, position p, Type type) {
        super(p, type);
        op = opt;
        e = exp;
    }
}