import java.util.ArrayList;

public class Memory {
    private int length;
    private ArrayList<MemoryBlock> MemoryBlocks;

    public void insertRequest(Request work) {

    }

    public void deleteRequest(Request work) {
        int i = 0;
        while (MemoryBlocks.get(i).getWorkName() != work) {
            i++;
        }
        MemoryBlocks.get(i).setWorkName(null);
    }

    public void printMemoryMap() {
        for (MemoryBlock mb :
                MemoryBlocks) {
            System.out.print(mb.getStart());
            System.out.print("/");
            System.out.print(mb.getLength());
            System.out.print("/");
            System.out.print(mb.getState());
            System.out.print("/");
            System.out.print(mb.getWorkName());
        }
    }

    public void createNewMemoryBlock(int size) {
        MemoryBlock mb = new MemoryBlock(size);
        MemoryBlocks.add(mb);
    }

    public void mergeFreeMemoryBlock(MemoryBlock mb1, MemoryBlock mb2) {
        MemoryBlock mb = addMemoryBlcok(mb1, mb2);
        MemoryBlocks.add(MemoryBlocks.indexOf(mb1), mb);
        MemoryBlocks.remove(mb1);
        MemoryBlocks.remove(mb2);
    }

    private MemoryBlock addMemoryBlcok(MemoryBlock mb1, MemoryBlock mb2) {
        int length = mb1.getLength() + mb2.getLength();
        return new MemoryBlock(length);
    }

}
