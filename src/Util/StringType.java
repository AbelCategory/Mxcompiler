package Util;

public class StringType extends Type {
    public StringType() {
        super("String");
    }

    @Override
    public boolean equal(Object b) {
        return b.getClass().equals(StringType.class);
    }

    @Override
    public String toString() {
        return "String";
    }

    @Override
    public boolean isString() {return true;}

    @Override
    public String getTypename() {return "string";}
}
