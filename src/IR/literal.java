package IR;

public abstract class literal extends entity{
    literal(IRType t) {
        super(t);
    }

    public abstract String get_name();

    @Override public String toString() {return super.toString() + get_name();}
}
