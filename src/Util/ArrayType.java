package Util;

public class ArrayType extends Type {
    Type type;
    int dim;
//    int dim;
    public ArrayType(Type baseType, int dim) {
        super("Array");
        type = baseType;
        this.dim = dim;
    }

    @Override
    public boolean equal(Object b) {
        return b.getClass().equals(ArrayType.class) && type.equal(((ArrayType) b).type) && (dim == ((ArrayType) b).dim);
    }

    @Override
    public String toString() {
        return "array: " + type.toString();
    }
}
