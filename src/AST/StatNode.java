package AST;

import Util.position;

public abstract class StatNode extends ASTNode {
    public boolean isnw = false;
    public StatNode(position p) {
        super(p);
    }
}
