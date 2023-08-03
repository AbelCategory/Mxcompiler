package AST;

import Util.Type;
import Util.position;

public class typeNode extends ASTNode {
    public String type;
    public typeNode(String t) {
        super(null);
        type = t;
    }

    @Override public void accept(ASTVistor vis) {}

    public boolean isArray() {return false;}
}
