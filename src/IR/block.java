package IR;

import java.util.ArrayList;

public class block extends IRNode {
    public label L;
    static int cnt = 0;
    public ArrayList<statment> stats = new ArrayList<>();
    block(String lb) {
        super();
        ++cnt;
        L = new label(lb + "." + cnt, new lableType());
    }

//    block(String lb, )

    public void addInst(statment ins) {
        stats.add(ins);
    }

    @Override public String toString() {
        return L.get_name() + ":";
    }
}
