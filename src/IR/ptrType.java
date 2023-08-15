package IR;

public class ptrType extends IRType {
    public IRType type;
    public int dim;
    public ptrType(IRType t) {
//        type = t;
        if(t instanceof ptrType) {
            type = ((ptrType) t).type;
            dim = ((ptrType) t).dim + 1;
        } else {
            type = t;
            dim = 0;
        }
    }

    public ptrType(IRType t, int dim) {
        type = t;
        this.dim = dim;
    }

    @Override public String toString() {return "ptr";}

    @Override public int getBytes() {return 4;}
}
