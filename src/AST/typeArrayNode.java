package AST;

import Util.position;

public class typeArrayNode extends typeNode {
    public int dim;
    public typeArrayNode(String t, int dim) {
        super(t);
        this.dim = dim;
    }

    public boolean isArray() {return true;}
}
