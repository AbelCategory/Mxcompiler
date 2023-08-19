package IR;

public class literalStr extends literal {
    public String val;
    public int id;
    static int cnt;
    public literalStr(IRString t, String val) {
        super(t);
        this.val = val;
        id = ++cnt;
    }

    @Override
    public String get_name() {
        return "@.str." + id;
    }

    public String def() {
        StringBuilder str = new StringBuilder();
        int len = 0;
        for(int i = 0; i < val.length(); ++i) {
            if(val.charAt(i)=='\\') {
                char ch = val.charAt(i + 1);
                str.append('\\');
                ++i;
                switch (ch) {
                    case 'n'  -> str.append("0A");
                    case '\"' -> str.append("22");
                    case '\\' -> str.append("\\");
                    default -> throw new RuntimeException("string error");
                }
            } else {
                str.append(val.charAt(i));
            }
            ++len;
        }
        return "@.str." + id + " = private unnamed_addr constant [" + (len + 1) + " x i8] c\"" + str + "\\00\"";

    }
}
