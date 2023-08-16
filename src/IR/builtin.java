package IR;

import Util.globalScope;

public class builtin {
    public globalScope gScope;
    public IRBuilder irB;
    public builtin(globalScope gScope, IRBuilder b) {
        this.gScope = gScope;
        irB = b;
    }
}
