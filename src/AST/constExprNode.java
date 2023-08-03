package AST;

import Util.position;
import Util.Type;

public abstract class constExprNode extends exprNode{
    public constExprNode(position p, Type t) {
        super(p, t);
    }
}
