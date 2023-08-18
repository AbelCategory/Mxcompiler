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
        mod.str.forEach(s -> out.println(s.def()));
        mod.cls.forEach(this::visit);
        out.println();
        mod.gvar.forEach(g -> out.println(g.def()));
        out.println();
        mod.func.forEach(this::visit);
    }

    public void visit(IRFunc fun) {
        if(!fun.declare) {
            out.println();
            out.println(fun + "{");
//        visit(fun.entry);
            fun.suite.forEach(this::visit);
            out.println("}");
            out.println();
        } else {
            out.println(fun);
        }
    }

    public void visit(IRClass cl) {
        out.println(cl.def());
    }

    public void visit(block bl) {
        out.println(bl.toString());
        bl.stats.forEach(ins -> out.println("  " + ins.toString()));
        out.println();
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
