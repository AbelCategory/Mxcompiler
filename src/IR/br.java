package IR;

public class br extends statment {
    private boolean cond;
    public entity condRes, label1, label2;

    public br(entity cres, entity l1, entity l2) {
        super();
        cond = true;
        condRes = cres;
        label1 = l1;
        label2 = l2;
    }

    public br(entity l) {
        super();
        cond = false;
        label1 = l;
    }

    public boolean isCond() {return cond;}

    @Override public String toString() {
        if(cond) {
            return "br " + condRes.toString() + ", " + label1.toString() + ", " + label2.toString();
        } else {
            return "br " + label1.toString();
        }
    }
}
