package AST;

import java.util.ArrayList;
import Util.Type;
import Util.position;

public class NewExpNode extends exprNode {
    public ArrayList<exprNode> arguments;
    public int dim;
    public NewExpNode(int d, position p, Type type) {
        super(p, type);
        dim = d;
//        arguments.addAll(arg);
        arguments = new ArrayList<>();
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
