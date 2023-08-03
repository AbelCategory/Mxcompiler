package Util;

import java.util.HashMap;

public abstract class Type
{
    public String Typename;
    public Type(String s) {Typename = s;}
    public abstract boolean equal(Object b);
    public abstract String toString();
}
