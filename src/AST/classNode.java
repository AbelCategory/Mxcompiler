package AST;

import java.util.ArrayList;
import Util.position;

public class classNode extends ASTNode {
    public ArrayList<varDefNode> varDef;
    public ArrayList<funcNode> funcDef;
    public ArrayList<ASTNode> cdef;
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
        cdef = new ArrayList<>();
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
