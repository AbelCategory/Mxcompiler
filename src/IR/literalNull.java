package IR;

public class literalNull extends literal{
    public literalNull(null_Type t) {
        super(t);
    }

    @Override public String get_name() {return "null";}

    @Override public String toString() {return "null";}
}
