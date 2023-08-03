package Util;

import AST.typeNode;

public class funcParameter {
    public typeNode type;
    public position p;
    public String name;

    public funcParameter(String id, position pos, typeNode t) {
        name = id;
        p = pos;
        type = t;
    }
}
