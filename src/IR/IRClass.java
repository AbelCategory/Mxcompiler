package IR;

import java.util.ArrayList;
import java.util.HashMap;

public class IRClass extends IRType {
    public String name;
    public int size = 0;
    public ArrayList<IRType> typeList = new ArrayList<>();
    public HashMap<String, IRType> members = new HashMap<>();

    public IRClass(String name) {
        this.name = name;
    }

    public void addMember(IRType t) {
        typeList.add(t);
    }

    @Override public int getBytes() {return size;}

    @Override public String toString() {return "%struct." + name;}

    public String def() {
        StringBuilder ret = new StringBuilder(toString() + " = type {");
        for(int i = 0; i < typeList.size(); ++i) {
            if(i > 0) ret.append(",");
            ret.append(typeList.get(i).toString());
        }
        ret.append(" }");
        return ret.toString();
    }
}
