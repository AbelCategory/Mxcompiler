package AST;

import Util.position;
import Util.Type;
import java.util.ArrayList;

public class varDefNode extends StatNode {
    public Type type;
    public ArrayList<varNode> var;
    public varDefNode(Type t, position p) {
        super(p);
        type = t;
//        var.addAll(v);
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
