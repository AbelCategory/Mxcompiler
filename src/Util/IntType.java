package Util;

public class IntType extends Type {
    public IntType() {
        super("Int");
    }

    @Override
    public boolean equal(Object b) {
        return b.getClass().equals(IntType.class);
    }

    @Override
    public String toString() {
        return "Int";
    }

    @Override
    public boolean isInt() {return true;}

    @Override
    public String getTypename() {return "int";}
}
