package IR;

public class globalVar extends variable {
    public globalVar(String name, IRType t) {
        super(t, name);
    }

    @Override
    public String get_name() {return "@ " + name;}
}
