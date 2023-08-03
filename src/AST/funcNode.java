package AST;

import Util.position;
import Util.Type;
import Util.funcParameter;

import java.util.ArrayList;

public class funcNode extends ASTNode {
    public Type tp;
    public String name;
    public ArrayList<funcParameter> pa;
    public BlockStatNode body;
    public funcNode(String id, position pos, Type tp, BlockStatNode b) {
        super(pos);
        name = id;
        this.tp = tp;
        pa = new ArrayList<>();
        body = b;
    }

    @Override
    public void accept(ASTVistor vis) {
        vis.visit(this);
    }
}
