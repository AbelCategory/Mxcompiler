package Util;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public class position {
    private int row, col;

    public position(int r, int c) {
        row = r;
        col = c;
    }

    public position(Token token) {
        row = token.getLine();
        col = token.getCharPositionInLine();
    }

    public position(TerminalNode ter) {
        this(ter.getSymbol());
    }

    public position(ParserRuleContext ctx) {
        this(ctx.getStart());
    }

    public int getRow() {return row;}
    public int getCol() {return col;}
    public String toString() {return row + "," + col;}
}
