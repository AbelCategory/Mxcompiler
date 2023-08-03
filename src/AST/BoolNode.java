package AST;

import Util.position;
import Util.BoolType;

public class BoolNode extends constExprNode {
    boolean value;
    public BoolNode(boolean value, position p, BoolType t) {
        super(p, t);
    }

    @Override
    public void accept(ASTVistor vis) {

    }
}
