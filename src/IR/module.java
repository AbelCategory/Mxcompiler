package IR;

import java.util.ArrayList;

public class module extends IRNode {
    public ArrayList<IRFunc> func = new ArrayList<>();
    public ArrayList<IRClass> cls = new ArrayList<>();
    public ArrayList<globalVar> gvar = new ArrayList<>();
    public module() {
        super();
    }

    @Override
    public String toString() {return "";}
}
