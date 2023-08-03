package AST;

import Util.Type;
import Util.position;

public class preUpdateExpNode extends updateExpNode {
    public preUpdateExpNode(exprNode exp, UPDOperator opt, position p, Type type) {
        super(exp, opt, p, type);
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
