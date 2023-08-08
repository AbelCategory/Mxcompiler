package IR;

import java.util.ArrayList;

public class module extends IRNode {
    ArrayList<IRFunc> func = new ArrayList<>();
    ArrayList<statment> stat = new ArrayList<>();
    public module() {
        super();
    }

    @Override
    public String toString() {return "";}
}
