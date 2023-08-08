package IR;

public class ptrType extends IRType {
    public IRType type;
    public ptrType(IRType t) {
        type = t;
    }

    @Override public String toString() {return type.toString() + "*";}

    @Override public int getBytes() {return 4;}
}
