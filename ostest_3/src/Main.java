import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BitMap bitMap = new BitMap();
//        Work work = new Work("gg", 10);
//        bitMap.insertWork(work);
//
//        //bitMap.printBitMap();
//
//        bitMap.deleteWork(work);
//
//        //bitMap.printBitMap();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请选择操作： 1.插入 2.删除");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("字节号：");
                    int numByte = sc.nextInt();
                    System.out.println("位号");
                    int numBit = sc.nextInt();
                    bitMap.insertWork(numByte, numBit);
                    bitMap.printBitMap();
                    break;
                case 2:
                    System.out.println("柱面号");
                    int num1 = sc.nextInt();
                    System.out.println("磁道号");
                    int num2 = sc.nextInt();
                    System.out.println("物理记录号");
                    int num3 = sc.nextInt();
                    int num4 = num2*4 + num3;
                    bitMap.deleteWork(num1, num4);
                    bitMap.printBitMap();
                    break;
            }
        }
    }}
