package IR;

import java.util.ArrayList;

public class block extends IRNode {
    public label L;
    public ArrayList<statment> stats = new ArrayList<>();
    block(String lb) {
        super();
        L = new label(lb, new lableType());
    }

    @Override public String toString() {

    }
}
