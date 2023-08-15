package IR;

import java.util.ArrayList;

public class phi extends statment {
    public entity res;
    public ArrayList<label> lb = new ArrayList<>();
    public ArrayList<entity> val = new ArrayList<>();
    public phi(entity res) {
        super();
        this.res = res;
    }

    public void addVal(label l, entity v) {
        lb.add(l);
        val.add(v);
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder(res.get_name() + " = phi " + res.type.toString());
        int n = lb.size();
        for(int i = 0; i < n; ++i) {
            if(i != 0) ret.append(", ");
            ret.append("[");
            ret.append(val.get(i).get_name()).append(", ").append(lb.get(i).toString());
            ret.append("]");
        }
        return ret.toString();
    }
}
