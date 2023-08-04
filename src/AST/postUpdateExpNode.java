package AST;

import Util.Type;
import Util.position;

public class postUpdateExpNode extends updateExpNode {
    public postUpdateExpNode(exprNode exp, UPDOperator opt, position p, Type type) {
        super(exp, opt, p, type);
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }

    @Override
    public boolean isAssign() {return true;}
}
