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

    public void addMember(String member, IRType t) {
        typeList.add(t);
        members.put(member, t);
    }

    @Override public int getBytes() {return size;}

    @Override public String toString() {return "%struct." + name;}
}
