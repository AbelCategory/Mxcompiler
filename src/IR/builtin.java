package IR;

import Util.globalScope;

public class builtin{
    IRBuilder irb;
    ptrType ptr;
    I_Type Int;
    voidType Void;
    IRString str;
    globalScope gScope;
    public builtin(IRBuilder irb) {
        this.irb = irb;
        gScope = irb.gScope;
        ptr = irb.ptrIR;
        Int = irb.intIR;
        str = irb.strIR;
        Void = irb.voidIR;

        gScope.irf.put("array_malloc", "array_malloc");
        IRFunc array_alloc = new IRFunc("array_alloc", ptr, true);
        array_alloc.addAugment(new reg("n", Int));
        irb.topModule.addFunc(array_alloc);

        gScope.irf.put("class_malloc", "class_malloc");
        IRFunc class_alloc = new IRFunc("class_alloc", ptr, true);
        class_alloc.addAugment(new reg("n", Int));
        irb.topModule.addFunc(class_alloc);

        gScope.irf.put("print", "print");
        IRFunc print = new IRFunc("print", Void, true);
        print.addAugment(new reg("s", str));
        irb.topModule.addFunc(print);

        gScope.irf.put("println", "println");
        IRFunc println = new IRFunc("println", Void, true);
        println.addAugment(new reg("s", str));
        irb.topModule.addFunc(println);

        gScope.irf.put("printInt", "printInt");
        IRFunc printInt = new IRFunc("printInt", Void, true);
        printInt.addAugment(new reg("n", Int));
        irb.topModule.addFunc(printInt);

        gScope.irf.put("printlnInt", "printlnInt");
        IRFunc printlnInt = new IRFunc("printlnInt", Void,true);
        printlnInt.addAugment(new reg("n", Int));
        irb.topModule.addFunc(printlnInt);

        gScope.irf.put("getInt", "getInt");
        IRFunc getInt = new IRFunc("getInt", Int, true);
        irb.topModule.addFunc(getInt);

        gScope.irf.put("getString", "getString");
        IRFunc getString = new IRFunc("getString", str, true);
        irb.topModule.addFunc(getString);

        gScope.irf.put("toString", "toString");
        IRFunc toString = new IRFunc("toString", str, true);
        toString.addAugment(new reg("x", Int));
        irb.topModule.addFunc(toString);

        gScope.irf.put("string::length", "string_length");
        IRFunc string_length = new IRFunc("string_length", Int, true);
        string_length.addAugment(new reg("s", str));
        irb.topModule.addFunc(string_length);

        gScope.irf.put("string::substring", "string_substring");
        IRFunc string_substring = new IRFunc("string_substring", str, true);
        string_substring.addAugment(new reg("s", str));
        string_substring.addAugment(new reg("l", Int));
        string_substring.addAugment(new reg("r", Int));

        gScope.irf.put("string::parseInt", "string_parseInt");
        IRFunc string_parseInt = new IRFunc("string_parseInt", str, true);
        string_parseInt.addAugment(new reg("s", str));
        irb.topModule.addFunc(string_parseInt);

        gScope.irf.put("string::ord", "string_ord");
        IRFunc string_ord = new IRFunc("string_ord", Int, true);
        string_ord.addAugment(new reg("s", str));
        string_ord.addAugment(new reg("x", Int));
        irb.topModule.addFunc(string_ord);

        gScope.irf.put("_Array::size", "array_size");
        IRFunc array_size = new IRFunc("array_size", Int, true);
        array_size.addAugment(new reg("arr", ptr));
        irb.topModule.addFunc(array_size);

    }
}
