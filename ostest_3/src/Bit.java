public class Bit {
    private int byteIndex;
    private int index;
    private int state;
    private int physicalAddress;
    private Work work;

    public Bit(int byteIndex, int index) {
        this.byteIndex = byteIndex;
        this.index = index;
        this.state = 0;
        this.physicalAddress = 0;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getByteIndex() {
        return byteIndex;
    }

    public int getIndex() {
        return index;
    }

    public void setPhysicalAddress(int physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public int getPhysicalAddress() {
        return physicalAddress;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
}
