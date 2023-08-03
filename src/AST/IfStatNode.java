package AST;

import Util.position;

public class IfStatNode extends StatNode {
    public exprNode cond;
    public StatNode thenStat, elseStat;

    public IfStatNode(exprNode cond, StatNode th, StatNode el, position p) {
        super(p);
        this.cond = cond;
        thenStat = th;
        elseStat = el;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
