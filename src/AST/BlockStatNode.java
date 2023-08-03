package AST;

import java.util.ArrayList;
import Util.position;

public class BlockStatNode extends StatNode {
    public ArrayList<StatNode> stats;
    public BlockStatNode(position p) {
        super(p);
//        stats.addAll(s);
        stats = new ArrayList<StatNode>();
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
