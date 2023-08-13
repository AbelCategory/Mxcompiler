package IR;

public class localVar extends variable {
    public localVar(String name, IRType t) {
        super(t, name);
    }

    @Override
    public String get_name() {return "%" + name;}
}
