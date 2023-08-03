package AST;

import Util.position;

import java.util.ArrayList;

public class rtNode extends ASTNode {
    public ArrayList<classNode> classDef;
    public ArrayList<funcNode> funcDef;
    public ArrayList<varDefNode> varDef;
    funcNode mainFn;

    public rtNode(position p, funcNode mainFn) {
        super(p);
        classDef = new ArrayList<>();
        funcDef = new ArrayList<>();
        varDef = new ArrayList<>();
        this.mainFn = mainFn;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
