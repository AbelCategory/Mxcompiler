package IR;

import java.util.ArrayList;

public class IRFunc extends IRNode {
    IRType retype;
    String name;
    ArrayList<entity> para = new ArrayList<>();
    ArrayList<block> suite = new ArrayList<>();
    public IRFunc(String id, IRType type) {
        super();
        name = id;
        retype = type;
        suite.add(new block("entry", true));
    }

    public void addAugment(entity t) {
        para.add(t);
    }

    @Override public String toString() {
        StringBuilder cur = new StringBuilder("define dso_local" + retype.toString());
        cur.append("@ ").append(name).append("(");
        if(!para.isEmpty()) {
            cur.append(para.get(0).toString());
            int n = para.size();
            for(int i = 1; i < n; ++i) {
                cur.append(",").append(para.get(i).toString());
            }
        }
        return cur.toString();
    }
}
