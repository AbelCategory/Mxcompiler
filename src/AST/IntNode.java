package AST;

import Util.IntType;
import Util.position;

public class IntNode extends constExprNode {
    public int value;
    IntNode(int value, position p, IntType t) {
        super(p, t);
        this.value = value;
    }

    @Override
    public void accept(ASTVistor vis) {

    }
}
