package IR;

public class alloca extends statment {
    public entity e;
    public IRType t;
    public alloca(IRType t, entity e) {
        super();
        this.t = t;
        this.e = e;
    }

    @Override public String toString() {return e.get_name() + " = alloca " + t.toString();}
}
