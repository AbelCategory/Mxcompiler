package Util;

public class ArrayType extends Type {
    Type type;
//    int dim;
    public ArrayType(Type baseType) {
        super("Array");
        type = baseType;
    }

    @Override
    public boolean equal(Object b) {
        return b.getClass().equals(ArrayType.class) && type.equal(((ArrayType) b).type);
    }

    @Override
    public String toString() {
        return "array: " + type.toString();
    }
}
