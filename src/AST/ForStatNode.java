package AST;

import Util.position;

public abstract class ForStatNode extends LoopStatNode {
    public exprNode cond, step;
    public ForStatNode(exprNode cond, exprNode step, StatNode s, position p) {
        super(p, s);
        this.cond = cond;
        this.step = step;
    }
}
