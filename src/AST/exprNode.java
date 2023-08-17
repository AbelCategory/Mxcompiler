package AST;

import Util.Type;
import Util.position;
import IR.entity;
public abstract class exprNode extends ASTNode {
    public Type type;
    public entity ent, ptr;
    public boolean isLeft = false;
    public boolean arrayOk = false;

    public exprNode(position p, Type t) {
        super(p);
        type = t;
    }

    public boolean isAssign() {return false;}
}
