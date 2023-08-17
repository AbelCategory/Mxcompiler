package AST;

import Util.position;

public class NewExpNode extends exprNode {
    public newTypeNode tp;
    public typeNode typ;
    public NewExpNode(newTypeNode cur, position p) {
        super(p, null);
        tp = cur;
        if(cur.dim == 0){
            typ = new typeNode(cur.type);
        } else {
            typ = new typeArrayNode(cur.type, cur.dim);
        }
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}