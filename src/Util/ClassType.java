package Util;

import java.util.Objects;

public class ClassType extends Type {
    public String className;
    public ClassType(String s) {
        super("Class");
        className = s;
    }

    @Override
    public boolean equal(Object b) {
        return b.getClass().equals(ClassType.class) && className.equals(((ClassType) b).className);
    }

    @Override
    public String toString() {
        return className;
    }
}
