public class MemoryBlock {
    private int start;
    private int length;
    private int state;
    private Request workName;

    public MemoryBlock(int length) {
        this.length = length;
        this.state = 0;
    }

    public int getLength() {
        return length;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getState() {
        return state;

    }

    public Request getWorkName() {
        return workName;
    }

    public void setWorkName(Request work) {
        this.workName = workName;
    }

    public void setState(int state) {
        this.state = state;
    }
}
