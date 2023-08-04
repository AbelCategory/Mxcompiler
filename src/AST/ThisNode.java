package AST;

import Util.position;
import Util.nulltype;

public class ThisNode extends constExprNode {
    public ThisNode(position p) {
        super(p, null);
    }

    @Override
    public void accept(ASTVistor vis) {

    }
}
