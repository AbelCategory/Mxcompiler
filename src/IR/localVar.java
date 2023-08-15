package IR;

public class localVar extends variable {
    static int cnt = 0;
    int id;
    public localVar(String name, IRType t) {
        super(t, "var." + name + "." + (cnt + 1));
        id = ++cnt;
    }

    @Override
    public String get_name() {return "%" + name;}
}
