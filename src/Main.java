import java.io.*;

import AST.ASTBuilder;
import AST.SemanticCheck;
import AST.SymbolCollector;
import AST.rtNode;
import Error.error;
import Error.mxErrorListener;
import Util.globalScope;
import Parser.mxParser;
import Parser.mxLexer;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static boolean checkOk(String name) throws IOException{
        File file = new File(name);
        FileReader rd = new FileReader(file);
        BufferedReader br = new BufferedReader(rd);
        String line;
        while((line = br.readLine()) != null && !line.contains("Verdict"));
        if(line != null){
            return line.contains("Success");
        }
        return false;
    }


    public static void compile(InputStream input) throws Exception{
//        InputStream input = new FileInputStream(name);
//        InputStream input = System.in;
        System.out.println(">>>");
//        boolean ok = true, realOk = checkOk(name);
        try{
            globalScope gScope = new globalScope(null);

            mxLexer lexer = new mxLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new mxErrorListener());

            mxParser parser = new mxParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new mxErrorListener());
            ParseTree parseTreeRoot = parser.program();
            ASTBuilder astBuilder = new ASTBuilder(gScope);
            rtNode rt = (rtNode)astBuilder.visit(parseTreeRoot);

            new SymbolCollector(gScope).visit(rt);
            new SemanticCheck(gScope).visit(rt);
            System.out.println("Compiler OK");

        } catch (error er) {
            System.err.println(er.toString());
//            ok = false;
            throw new RuntimeException();
        }
//        if(ok != realOk) {
//            throw new RuntimeException();
////            while(true);
//        }
    }
    public static void main(String[] args) throws Exception {
//        InputStream input = new FileInputStream(name);
        InputStream input = System.in;
        compile(input);
//        compile("testcases/sema/misc-package/misc-6.mx");
//        File justList = new File("testcases/sema/judgelist.txt");
//        FileReader rd = new FileReader(justList);
//        BufferedReader br = new BufferedReader(rd);
//        String name;
//        while((name = br.readLine()) != null) {
//            String fileName = "testcases/sema" + name.substring(1);
//            System.out.println(fileName);
//            compile(fileName);
//        }
    }
}