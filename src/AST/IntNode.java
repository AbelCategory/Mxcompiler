package AST;

import Util.IntType;
import Util.position;

public class IntNode extends constExprNode {
    public long value;
    IntNode(long value, position p, IntType t) {
        super(p, t);
        this.value = value;
    }
}
