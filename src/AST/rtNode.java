package AST;

import Util.position;

import java.util.ArrayList;

public class rtNode extends ASTNode {
    public ArrayList<classNode> classDef;
    public ArrayList<funcNode> funcDef;
    public ArrayList<varDefNode> varDef;
    public ArrayList<ASTNode> def;
    public funcNode mainFn;

    public rtNode(position p) {
        super(p);
        classDef = new ArrayList<>();
        funcDef = new ArrayList<>();
        varDef = new ArrayList<>();
        def = new ArrayList<>();
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
