package IR;

public class reg extends entity {
    public String name;
    public int id;
    public static int cnt = 0;
    public reg(String name, IRType t) {
        super(t);
        this.name = name;
        id = ++cnt;
    }

    @Override public String toString() {return type.toString() + " %" + name + "." + id;}
    @Override public String get_name() {return "%" + name + "." + id;}

}
