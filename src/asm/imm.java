package asm;

public class imm extends operand {
    public long value;
    public imm(long value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Long.toString(value);
    }
}
