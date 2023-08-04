package AST;

import Util.position;
import Util.StringType;

public class StringNode extends constExprNode {
    public String value;
    public StringNode(String value, position p, StringType t) {
        super(p, t);
        this.value = value;
    }
}
