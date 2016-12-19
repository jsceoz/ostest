import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入内存大小(kb):");
        int userSettingLength = sc.nextInt();

        Memory memory = new Memory(userSettingLength);

        Work work1 = new Work("homework1", 10);
        Work work2 = new Work("homework2", 10);
        Work work3 = new Work("homework3", 5);

        memory.insertWork(work1);
        memory.insertWork(work2);
        memory.deleteWork(work1);
        memory.insertWork(work3);

        memory.checkAndPrintMemoryBlocks();
    }
}
