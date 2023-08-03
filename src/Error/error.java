package Error;

import Util.position;

public class error extends RuntimeException {
    private String msg;
    private position p;
    public error(String msg, position p) {
        this.msg = msg;
        this.p = p;
    }

    public String toString() {
        return msg + ": " + p.toString();
    }
}
