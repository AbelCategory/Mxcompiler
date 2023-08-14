package Error;

import Util.position;

public class internalError extends Error {
    public internalError(String msg) {
        super("Internal error: " + msg);
    }
}
