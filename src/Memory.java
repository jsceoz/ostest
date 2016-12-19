import java.util.ArrayList;

public class Memory {
    private int length;
    private ArrayList<MemoryBlock> MemoryBlocks;

    public Memory(int length) {
        this.length = length;
        this.MemoryBlocks = new ArrayList<MemoryBlock>();
    }

    public void insertWork(Work work) {
        for (MemoryBlock mb:
             MemoryBlocks) {
            if (mb.getState() == 0 && work.getLength() <= mb.getLength()) {
                if (mb.getLength() == work.getLength()) {
                    mb.setWork(work);
                    mb.setState(1);
                    return;
                }
                else {
                    splitMemoryBlockAndInsertWork(mb, work);
                    return;
                }
            }
        }
        if (length - getMemoryBlocksLength() >= work.getLength()) {
            createNewMemoryBlock(work);
        }
    }

    public void deleteWork(Work work) {
        int i = 0;
        while (MemoryBlocks.get(i).getWork() != work) {
            i++;
        }
        System.out.println(i);
        MemoryBlocks.get(i).setWork(null);
        MemoryBlocks.get(i).setState(0);
    }

    public void checkAndPrintMemoryBlocks() {
        for (MemoryBlock mb :
                MemoryBlocks) {
            if (mb.getState() == 0 && MemoryBlocks.get(MemoryBlocks.indexOf(mb) + 1).getState() == 0) {
                mergeFreeMemoryBlock(mb, MemoryBlocks.get(MemoryBlocks.indexOf(mb) + 1));
            }
        }
        int currentAdd = 0;
        for (MemoryBlock mb:
             MemoryBlocks) {
            mb.setStart(currentAdd);
            System.out.print(mb.getStart());
            System.out.print("/");
            System.out.print(mb.getLength());
            System.out.print("/");
            System.out.print(mb.getState());
            System.out.print("/");
            System.out.println(mb.getWorkName());
            currentAdd += mb.getLength();
        }
        if (currentAdd < length) {
            System.out.print(currentAdd);
            System.out.print("/");
            System.out.print(length - currentAdd);
            System.out.print("/");
            System.out.print(0);
            System.out.print("/");
            System.out.println("FREE");
        }
    }

    public void createNewMemoryBlock(Work work) {
        MemoryBlock mb = new MemoryBlock(work.getLength(), work);
        MemoryBlocks.add(mb);
    }

    public void mergeFreeMemoryBlock(MemoryBlock mb1, MemoryBlock mb2) {
        MemoryBlock mb = addMemoryBlock(mb1, mb2);
        MemoryBlocks.add(MemoryBlocks.indexOf(mb1), mb);
        MemoryBlocks.remove(mb1);
        MemoryBlocks.remove(mb2);
    }

    private MemoryBlock addMemoryBlock(MemoryBlock mb1, MemoryBlock mb2) {
        int length = mb1.getLength() + mb2.getLength();
        return new MemoryBlock(length);
    }

    private void splitMemoryBlockAndInsertWork(MemoryBlock mb, Work work) {
        int newMbLength = mb.getLength() - work.getLength();
        int index = MemoryBlocks.indexOf(mb) + 1;
        MemoryBlock newMb = new MemoryBlock(newMbLength);
        mb.setState(1);
        mb.setWork(work);
        mb.setLength(work.getLength());
        MemoryBlocks.add(index, newMb);
    }

    private int getMemoryBlocksLength() {
        int len = 0;
        for (MemoryBlock mb:
             MemoryBlocks) {
            len += mb.getLength();
        }
        return len;
    }

}


























