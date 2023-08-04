package AST;

import Util.position;
import Util.nulltype;

public class NullNode extends constExprNode{
    public NullNode(position p, nulltype type) {
        super(p, type);
    }
}
