package AST;

import Util.position;

public class NullNode extends constExprNode{
    public NullNode(position p) {
        super(p, null);
    }

    @Override
    public void accept(ASTVistor vis) {

    }
}
