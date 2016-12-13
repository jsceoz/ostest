public class Main {

    public static void main(String[] args) {
        PCBList runningList = new PCBList();
        runningList.sort();
        for (int i = 0; i < 5; i++) {
            System.out.println(runningList.pcbs[i].access);
        }
    }
}
