package IR;

import java.io.PrintStream;

public class IRPrinter implements IRPass {
    private PrintStream out;

    public IRPrinter(PrintStream writer) {
        out = writer;
    }

    public IRPrinter() {
        out = System.out;
    }
    public void visit(module mod) {
        mod.cls.forEach(this::visit);
        out.println();
        mod.gvar.forEach(g -> out.println(g.def()));
        out.println();
        mod.func.forEach(this::visit);
    }

    public void visit(IRFunc fun) {
        out.println();
        if(!fun.declare) {
            out.println(fun + "{");
//        visit(fun.entry);
            fun.suite.forEach(this::visit);
            out.println("}");
        } else {
            out.println(fun);
        }
        out.println();
    }

    public void visit(IRClass cl) {}

    public void visit(block bl) {
        out.println(bl.toString());
        bl.stats.forEach(ins -> out.println("  " + ins.toString()));
    }

    public void visit(arith x) {}
    public void visit(icmp x) {}
    public void visit(alloca x) {}
    public void visit(load x) {}
    public void visit(store x) {}
    public void visit(br x) {}
    public void visit(ret x) {}
    public void visit(call x) {}
    public void visit(phi x) {}
    public void visit(getelementptr x) {}
    public void visit(convert x) {}
}
