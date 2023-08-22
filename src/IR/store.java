package IR;

public class store extends statment{
    public IRType t;
    public entity val, ptr;

    public store(IRType tp, entity v, entity p) {
        super();
        t = tp;
        val = v;
        ptr = p;
    }

    @Override public String toString() {return "store " + t.toString() + " " + val.get_name() + ", ptr " + ptr.get_name();}

    @Override
    public void accept(IRPass pass) {
        pass.visit(this);
    }
}
