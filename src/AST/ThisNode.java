package AST;

import Util.position;
import Util.nulltype;

public class ThisNode extends constExprNode {
    public ThisNode(position p, nulltype t) {
        super(p, t);
    }

    @Override
    public void accept(ASTVistor vis) {

    }
}
