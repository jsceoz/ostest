public class PCBList {

    public PCB[] pcbs;

    public PCBList() {
        PCB[] pcb_list = new PCB[5];
        pcb_list[0] = new PCB("p1", 10, 10);
        pcb_list[1] = new PCB("p2", 9, 7);
        pcb_list[2] = new PCB("p3", 8, 8);
        pcb_list[3] = new PCB("p4", 7, 45);
        pcb_list[4] = new PCB("p5", 6, 6);
        this.pcbs = pcb_list;
    }

    public void sort() {
        PCB pcb_s;
        for (int i = 0; i < 5; i++) {
            for (int j = i + 1; j < 5; j++) {
                if (pcbs[i].access < pcbs[j].access || pcbs[i] == null) {
                    pcb_s = pcbs[i];
                    pcbs[i] = pcbs[j];
                    pcbs[j] = pcb_s;
                }
            }
        }
    }

    public void run() {
        while (pcbs[0] != null) {
            pcbs[0].run();
            print();
            if (pcbs[0].state == 0) {
                pcbs[0] = null;
            }
            sort();
        }
    }

    public void init() {
        sort();
    }

    public void print() {
        System.out.println("Current process");
        System.out.println(pcbs[0].name);
        for (int i = 1; i < 5; i++) {
            System.out.println(pcbs[i].name);
        }
    }
}
