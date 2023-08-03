package Error;

import Util.position;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.RecognitionException;

public class mxErrorListener extends BaseErrorListener {
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPosition, String msg, RecognitionException e) {
        throw new syntaxError(msg, new position(line, charPosition));
    }
}
