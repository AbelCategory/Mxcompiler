package IR;

public abstract class variable extends entity {
    String name;
    variable(IRType t, String name) {
        super(t);
        this.name = name;
    }
}
