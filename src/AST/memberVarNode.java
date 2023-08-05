package AST;

import Util.Type;
import Util.position;

public class memberVarNode extends exprNode {
    public exprNode obj;
    public String varName;
    public memberVarNode(exprNode lh, String ID, position p, Type type) {
        super(p, type);
        obj = lh;
        varName = ID;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }

    @Override public boolean isAssign() {
//        if(obj.getClass().equals(ThisNode.class)) return true;
//        return obj.isAssign();
        return true;
    }
}
