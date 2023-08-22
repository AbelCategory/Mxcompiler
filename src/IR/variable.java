package IR;

public abstract class variable extends entity {
    public String name;
    variable(IRType t, String name) {
        super(t);
        this.name = name;
    }

    @Override
    public String toString() {return type.toString() + " " + get_name();}
}
