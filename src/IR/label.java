package IR;

public class label extends entity {
    public String name;
    public label(String id, lableType t) {
        super(t);
        this.name = id;
    }

    @Override
    public String toString() {return super.toString() + " %" + name;}

    @Override
    public String get_name() {return name;}
}
