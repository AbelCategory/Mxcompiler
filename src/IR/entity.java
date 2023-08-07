package IR;

public abstract class entity extends IRNode {
    IRType type;
    public entity(IRType t) {
        type = t;
    }

    @Override
    public String toString() {return type.toString();}
}
