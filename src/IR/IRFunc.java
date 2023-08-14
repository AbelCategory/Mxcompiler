package IR;

import java.util.ArrayList;

public class IRFunc extends IRNode {
    IRType retype;
    String name;
    ArrayList<variable> para = new ArrayList<>();
    ArrayList<block> suite = new ArrayList<>();
    public IRFunc(String id, IRType type) {
        super();
        name = id;
        retype = type;
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
        if(!suite.isEmpty()) {
            cur.append("{\n");
            for(block blk : suite)
                cur.append(blk.toString());
            cur.append("}");
        }
        return cur.toString();
    }
}
