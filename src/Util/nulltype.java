package Util;

public class nulltype extends Type {
    public nulltype() {
        super("Null");
    }

    @Override
    public boolean equal(Object b) {
        return b.getClass().equals(nulltype.class);
    }

    @Override
    public String toString() {
        return "Null";
    }
}
