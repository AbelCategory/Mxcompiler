package Error;

import Util.position;

public class syntaxError extends error {
    public syntaxError(String msg, position p) {
        super("Syntax error:" + msg, p);
    }
}
