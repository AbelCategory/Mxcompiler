package IR;

public class ret extends statment {
    public boolean isvoid;
    public entity retEntity;

    public ret() {
        super();
        isvoid = true;
    }

    public ret(entity retEntity) {
        super();
        isvoid = false;
        this.retEntity = retEntity;
    }

    public boolean isVoid() {return isvoid;}

    @Override public String toString() {
        if(isvoid) {
            return "ret void";
        } else {
            return "ret" + retEntity.toString();
        }
    }
}
