package AST;

import Util.position;
import Util.Type;
import java.util.ArrayList;

public class varDefNode extends StatNode {
    public typeNode type;
    public ArrayList<varNode> var;
    public varDefNode(typeNode t, position p) {
        super(p);
        type = t;
        var = new ArrayList<>();
//        var.addAll(v);
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
