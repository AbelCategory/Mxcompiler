package IR;

import java.util.ArrayList;

public class IRClass extends IRType {
    public String name;
    public int size = 0;
    public ArrayList<IRType> typeList = new ArrayList<>();

    public IRClass(String name) {
        this.name = name;
    }

    @Override public int getBytes() {return size;}

    @Override public String toString() {return "%struct." + name;}
}
