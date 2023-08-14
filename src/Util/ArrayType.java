package Util;

public class ArrayType extends Type {
    public Type type;
    public int dim;
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

    @Override
    public boolean isArray() {return true;}

    public Type index() {
        if(dim == 1) {
            return type;
        } else {
            return new ArrayType(type, dim - 1);
        }
    }

    @Override
    public String getTypename() {return "_Array";}
}
