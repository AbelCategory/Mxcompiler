package IR;

public abstract class literal extends entity{
    literal(IRType t) {
        super(t);
    }
    @Override public String toString() {return super.toString() + get_name();}
}
