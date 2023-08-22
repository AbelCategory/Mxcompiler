package IR;

public abstract class IRNode {
    public abstract String toString();
    public abstract void accept(IRPass pass);
}