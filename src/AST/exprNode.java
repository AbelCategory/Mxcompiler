package AST;

import Util.Type;
import Util.position;
public abstract class exprNode extends ASTNode {
    public Type type;
    public boolean arrayOk = false;

    public exprNode(position p, Type t) {
        super(p);
        type = t;
    }

    public boolean isAssign() {return false;}
}
