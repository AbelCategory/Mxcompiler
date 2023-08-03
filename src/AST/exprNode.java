package AST;

import Util.Type;
import Util.position;
public abstract class exprNode extends ASTNode {
    public Type type;

    public exprNode(position p, Type t) {
        super(p);
        type = t;
    }
}
