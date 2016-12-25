import java.util.ArrayList;

public class Byte {
    private int index;
    private ArrayList<Bit> bits;

    public Byte(int index) {
        this.index = index;
        ArrayList<Bit> newBits = new ArrayList<Bit>();
        for (int i = 0; i < 8; i++) {
            newBits.add(new Bit(index, i));
        }
        this.bits = newBits;
    }

    public ArrayList<Bit> getBits() {
        return bits;
    }

    public void setBits(ArrayList<Bit> bits) {
        this.bits = bits;
    }
}
