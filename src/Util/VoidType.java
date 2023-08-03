package Util;

public class VoidType extends Type {
    public VoidType() {
        super("Void");
    }

    @Override
    public boolean equal(Object b) {
        return b.getClass().equals(VoidType.class);
    }

    @Override
    public String toString() {
        return "Void";
    }
}
