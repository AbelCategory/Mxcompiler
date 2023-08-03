package Util;

public class BoolType extends Type {
    public BoolType() {
        super("Bool");
    }

    @Override
    public boolean equal(Object b) {
        return b.getClass().equals(BoolType.class);
    }

    @Override
    public String toString() {
        return "Bool";
    }

    @Override
    public boolean isBool() {return true;}
}
