package Util;

import java.util.HashMap;

public abstract class Type
{
    public String Typename;
    public Type(String s) {Typename = s;}
    public abstract boolean equal(Object b);
    public abstract String toString();

    public boolean isInt() {return false;}
    public boolean isBool() {return false;}
    public boolean isString() {return false;}
    public boolean isVoid() {return  false;}
    public boolean isNull() {return false;}

    public boolean isArray() {return false;}
    public boolean isClass() {return false;}
}
