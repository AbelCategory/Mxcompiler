package AST;

import java.util.ArrayList;

public class newTypeNode extends ASTNode {
    public int dim;
    public String type;
    public ArrayList<exprNode> exprs;
    public newTypeNode(String type, int dim) {
        super(null);
        this.type = type;
        this.dim = dim;
        exprs = new ArrayList<>();
    }

    @Override public void accept(ASTVistor x) {

    }
}
