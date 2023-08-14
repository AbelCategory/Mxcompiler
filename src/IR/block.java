package IR;

import java.util.ArrayList;

public class block extends IRNode {
    public label L;
    public ArrayList<statment> stats = new ArrayList<>();
    block(String lb) {
        super();
        L = new label(lb, new lableType());
    }

    public void addInst(statment ins) {
        stats.add(ins);
    }

    @Override public String toString() {
        return null;
    }
}
