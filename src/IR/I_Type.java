package IR;

public class I_Type extends IRType {
    public int i_N;
    public I_Type(int i_N) {
        this.i_N = i_N;
    }

    @Override
    public String toString() {
        return "i" + i_N;
    }

    @Override
    public int getBytes() {return i_N == 1 ? 1 : i_N / 8;}
}
