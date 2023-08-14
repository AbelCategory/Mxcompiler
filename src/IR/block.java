package IR;

import java.util.LinkedList;

public class block extends IRNode {
    public label L;
    static int cnt = 0;
    public LinkedList<statment> stats = new LinkedList<>();
    block(String lb) {
        super();
        ++cnt;
        L = new label(lb + "." + cnt, new lableType());
    }

    block(String lb, boolean b) {
        super();
        L = new label(lb, new lableType());
    }

    public void addInst(statment ins) {
        stats.add(ins);
    }

    @Override public String toString() {
        return L.get_name() + ":";
    }
}
