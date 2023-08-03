package AST;

import Util.position;

public class ForExpStatNode extends ForStatNode {
    public exprNode init;
    public ForExpStatNode(exprNode init, exprNode cond, exprNode step, StatNode s, position p){
        super(cond, step, s, p);
        this.init = init;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
