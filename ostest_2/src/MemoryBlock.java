public class MemoryBlock {
    private int start;
    private int length;
    private int state;
    private Work work;

    public MemoryBlock(int length) {
        this.length = length;
        this.state = 0;
    }

    public MemoryBlock(int length, Work work) {
        this.length = length;
        this.work = work;
        this.state = 1;
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

    public Work getWork() {
        return work;
    }

    public String getWorkName() {
        if (work == null) {
            return "FREE";
        }
        else {
            return work.getName();
        }
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
