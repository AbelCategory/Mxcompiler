package IR;

import java.util.ArrayList;

public class module extends IRNode {
    public ArrayList<IRFunc> func = new ArrayList<>();
    public ArrayList<IRClass> cls = new ArrayList<>();
    public ArrayList<globalVar> gvar = new ArrayList<>();

    public ArrayList<literalStr> str = new ArrayList<>();
    public module() {
        super();
    }

    public void addFunc(IRFunc fn) {func.add(fn);}

    public void addVar(globalVar gv) {gvar.add(gv);}

    public void addClass(IRClass c) {cls.add(c);}

    @Override
    public String toString() {return "";}
}
