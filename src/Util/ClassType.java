package Util;

import java.util.HashMap;
import Error.semanticError;

public class ClassType extends Type {
    public String className;
    public ClassType(String s) {
        super("Class");
        className = s;
    }

    @Override
    public boolean equal(Object b) {
        if(b.getClass().equals(nulltype.class)) return true;
        return b.getClass().equals(ClassType.class) && className.equals(((ClassType) b).className);
    }

    @Override
    public String toString() {
        return className;
    }

    @Override public boolean isClass() {return true;}

    @Override
    public String getTypename() {return className;}
}
