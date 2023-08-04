import java.io.FileInputStream;
import java.io.InputStream;

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
    public static void main(String[] args) throws Exception {
        String name = "1.mx";
        InputStream input = new FileInputStream(name);
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
            throw new RuntimeException();
        }
    }
}