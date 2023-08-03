package AST;

import Util.position;

public abstract class LoopStatNode extends StatNode {
    public StatNode body;
    public LoopStatNode(position p, StatNode b) {
        super(p);
        body = b;
    }
}
