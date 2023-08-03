package AST;

import java.util.ArrayList;
import Util.position;

public class classNode extends ASTNode {
    public ArrayList<varNode> varDef;
    public ArrayList<funcNode> funcDef;
    public funcNode constructor;
    public String name;

    public classNode(String id, position pos) {
        super(pos);
        name = id;
//        varDef.addAll(va);
//        funcDef.addAll(fu);
        varDef = new ArrayList<>();
        funcDef = new ArrayList<>();
        constructor = null;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
