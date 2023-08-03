package AST;

import Util.position;

abstract public class ASTNode {
    public position pos;
    public ASTNode(position p) {
        pos = p;
    }
    abstract public void accept(ASTVistor vis);
}
