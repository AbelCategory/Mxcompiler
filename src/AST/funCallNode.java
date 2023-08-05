package AST;

import Util.position;
import Util.Type;

import java.util.ArrayList;

public class funCallNode extends exprNode{
    public String funcName;
    public ArrayList<exprNode> arguments;
    public funCallNode(String funcID, position p, Type type) {
        super(p, type);
        funcName = funcID;
//        arguments.addAll(a);
        arguments = new ArrayList<>();
        arrayOk = true;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }

//    @Override
//    public boolean isAssign() {return type.isArray() || type.isClass();}
}
