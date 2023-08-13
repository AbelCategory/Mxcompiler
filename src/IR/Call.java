package IR;

import java.util.ArrayList;

public class call extends statment {
    public entity rd;
    public IRType retType;
    public String name;
    public ArrayList<entity> para;

    public call(entity rd, IRFunc fn) {
        super();
        this.rd = rd;
        name = fn.name;
        para = new ArrayList<>();
    }

    @Override public String toString() {
        StringBuilder ret = new StringBuilder((rd == null ? "" : rd.get_name() + " = ") + "call " + retType.toString() + " @" + name + "(");
        int n = para.size();
        for(int i = 0; i < n; ++i) {
            if(i > 0) ret.append(", ");
            ret.append(para.get(i).get_name());
        }
        return ret.toString();
    }
}
