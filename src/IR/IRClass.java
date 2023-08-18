package IR;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class IRClass extends IRType {
    public String name;
    public boolean constructor = false;
    public int size = 0;
    public ArrayList<IRType> typeList = new ArrayList<>();
    public HashMap<String, Integer> members = new HashMap<>();
    public HashSet<String> memberFunc = new HashSet<>();

    public IRClass(String name) {
        this.name = name;
    }

    public void addMember(IRType t, String id) {
        typeList.add(t);
        members.put(id, size);
        size ++;
    }

    public void addMemberFun(String id) {
        memberFunc.add(id);
    }

    public boolean funDefined(String id) {
        return memberFunc.contains(id);
    }

    public boolean varDefined(String id) {
        return members.containsKey(id);
    }

    @Override public int getBytes() {return size * 4;}

    @Override public String toString() {return "%struct." + name;}

    public String def() {
        StringBuilder ret = new StringBuilder(this + " = type {");
        for(int i = 0; i < typeList.size(); ++i) {
            if(i > 0) ret.append(",");
            if(typeList.get(i) instanceof I_Type)  ret.append(" i32");
            else ret.append(" ptr");
            //ret.append(typeList.get(i).toString());
        }
        ret.append(" }");
        return ret.toString();
    }

    @Override public boolean isConstructor() {return constructor;}
}
