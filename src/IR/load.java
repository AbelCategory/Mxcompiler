package IR;

public class load extends statment {
    public IRType t;
    public entity val, ptr;
    public load(IRType tp, entity v, entity p) {
        super();
        t = tp;
        val = v;
        ptr = p;
    }
    @Override public String toString() {return val.get_name() + " = load " + t.toString() + ", ptr " + ptr.get_name();}
}
