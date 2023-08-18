package IR;

import java.util.ArrayList;

public class call extends statment {
    public entity rd;
    public IRType retType;
    public String name;
    public ArrayList<entity> para;

    public call(entity rd, String fn) {
        super();
        this.rd = rd;
        name = fn;
        para = new ArrayList<>();
    }

    public void addParameter(entity p) {
        para.add(p);
    }
    //
    @Override public String toString() {
        StringBuilder ret = new StringBuilder((rd == null ? "" : rd.get_name() + " = ") + "call " + retType.toString() + " @" + name + "(");
        int n = para.size();
        for(int i = 0; i < n; ++i) {
            if(i > 0) ret.append(", ");
            ret.append(para.get(i).toString());
        }
        ret.append(")");
        return ret.toString();
    }
}