import java.util.ArrayList;

public class BitMap {
    private ArrayList<Byte> bytes;

    public BitMap() {
        ArrayList<Byte> newBytes = new ArrayList<Byte>();
        for (int i = 0; i < 8; i++) {
            newBytes.add(new Byte(i));
        }
        this.bytes = newBytes;
    }

    public ArrayList<Byte> getBytes() {
        return bytes;
    }

    public void setBytes(ArrayList<Byte> bytes) {
        this.bytes = bytes;
    }

    public void setPhysicalAddress(Bit bit) {
        bit.setPhysicalAddress(bit.getByteIndex()*100 + (bit.getIndex()/4)*10 + bit.getIndex() % 4);
    }

    public void printBitMap() {
        for (Byte e:
             bytes) {
            for (Bit b:
                 e.getBits()) {
                System.out.print(b.getState());
            }
            System.out.print(" ");
        }
        System.out.println();
    }

    public void insertWork(Work work) {
        boolean isFind = false;
        for (Byte e:
             bytes) {
            for (Bit b:
                 e.getBits()) {
                if (b.getState() == 0) {
                    b.setState(1);
                    b.setWork(work);
                    setPhysicalAddress(b);
                    System.out.println(b.getPhysicalAddress());
                    printBitMap();
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                break;
            }
        }
    }

    public void insertWork(int numByte, int numBit) {
        bytes.get(numByte).getBits().get(numBit).setState(1);
    }

    public void deleteWork(Work work) {
        boolean isFind = false;
        for (Byte e:
             bytes) {
            for (Bit b:
                 e.getBits()) {
                if (b.getWork() == work) {
                    isFind = true;
                    b.setState(0);
                    b.setWork(null);
                    System.out.println(b.getByteIndex());
                    System.out.println(b.getIndex());
                    printBitMap();
                    break;
                }
                if (isFind) {
                    break;
                }
            }
        }
    }

    public void deleteWork(int num1, int num2) {
        bytes.get(num1).getBits().get(num2).setState(0);
    }
}
