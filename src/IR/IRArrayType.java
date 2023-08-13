package IR;

import Util.Type;

public class IRArrayType extends IRType {
    public IRType elm;
    public int len;

    public IRArrayType(IRType elm, int len) {
        this.elm = elm;
        this.len = len;
    }

    @Override public int getBytes() {return elm.getBytes() * len;}

    @Override public String toString() {return "[" + len + " x" + elm.toString() + "]";}
}
