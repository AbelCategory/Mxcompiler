package AST;

import java.util.ArrayList;
import Util.Type;
import Util.position;

public class memberFuncNode extends exprNode {
    public exprNode obj;
    public String funcName;
    public ArrayList<exprNode> arguments;

    public memberFuncNode(exprNode lh, String ID, position p, Type type) {
        super(p, type);
        obj = lh;
        funcName = ID;
//        arguments.addAll(arg);
        arguments = new ArrayList<>();
        arrayOk = true;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }

//    @Override
//    public boolean isAssign() {
//        return type.isClass() || type.isArray();
//    }
}
