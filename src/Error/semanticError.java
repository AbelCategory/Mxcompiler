package Error;

import Util.position;

public class semanticError extends error {
    public semanticError(String msg, position p) {
        super("Semantic error: " + msg, p);
    }
}
