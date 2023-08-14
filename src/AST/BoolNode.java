package AST;

import Util.position;
import Util.BoolType;

public class BoolNode extends constExprNode {
    public boolean value;
    public BoolNode(boolean value, position p, BoolType t) {
        super(p, t);
        this.value = value;
    }
}
