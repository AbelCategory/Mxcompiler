package IR;

import java.util.ArrayList;

public class IRFunc extends IRNode {
    IRType retype;
    String name;
    ArrayList<variable> para = new ArrayList<>();
    ArrayList<block> suite = new ArrayList<>();
    public IRFunc(String id, IRType type) {
        super();
        name = id;
        retype = type;
    }

    @Override
}
