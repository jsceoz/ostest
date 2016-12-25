import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Resource rA = new Resource("A", 4);
        Resource rB = new Resource("B", 12);
        Resource rC = new Resource("C", 11);
        Resource rD = new Resource("D", 10);

        HashMap<Resource, Integer> maxMap = new HashMap<Resource, Integer>();

        maxMap.put(rA, 0);
        maxMap.put(rB, 6);
        maxMap.put(rC, 5);
        maxMap.put(rD, 6);
        Work p1 = new Work("p1", maxMap);

        //System.out.println(p1.resourceMaxMap);

        maxMap.clear();

        maxMap.put(rA, 1);
        maxMap.put(rB, 9);
        maxMap.put(rC, 4);
        maxMap.put(rD, 2);
        Work p2 = new Work("p2", maxMap);

        //System.out.println(p1.resourceMaxMap);

        maxMap.clear();

        maxMap.put(rA, 1);
        maxMap.put(rB, 3);
        maxMap.put(rC, 5);
        maxMap.put(rD, 6);
        Work p3 = new Work("p3", maxMap);

        maxMap.clear();

        maxMap.put(rA, 1);
        maxMap.put(rB, 7);
        maxMap.put(rC, 5);
        maxMap.put(rD, 0);
        Work p4 = new Work("p4", maxMap);



        ArrayList<Work> works = new ArrayList<Work>();

        works.add(p1);
        works.add(p2);
        works.add(p3);
        works.add(p4);

        //System.out.println(p1.resourceMaxMap);

        rA.allocate(p1, 0);
        rA.allocate(p2, 1);
        rA.allocate(p3, 1);
        rA.allocate(p4, 1);

        rB.allocate(p1, 0);
        rB.allocate(p2, 4);
        rB.allocate(p3, 3);
        rB.allocate(p4, 0);

        rC.allocate(p1, 1);
        rC.allocate(p2, 3);
        rC.allocate(p3, 5);
        rC.allocate(p4, 0);

        rD.allocate(p1, 4);
        rD.allocate(p2, 2);
        rD.allocate(p3, 4);
        rD.allocate(p4, 0);

        System.out.println(p1.resourceMaxMap);
        //System.out.println(p3.resourceNeedMap);
        //System.out.println(works.size());

        while (true) {
            for (Work work:
                    works) {
                if (!work.isFinish()) {
                    //System.out.println(work.isFinish());
                    boolean isFind = true;
                    for (Resource r:
                            work.resourceNeedMap.keySet()) {
                        if ( r.getAvailable() < work.resourceNeedMap.get(r)) {
                            isFind = false;
                        }
                    }
                    if (isFind) {
                        for (Resource r:
                                work.resourceNeedMap.keySet()) {
                            r.allocate(work, work.resourceNeedMap.get(r));
                            r.retake(work);
                        }
                        System.out.println(work.getName());
                        System.out.println(work.isFinish());
                        System.out.println(rA.getAvailable());
                        System.out.println(rB.getAvailable());
                        System.out.println(rC.getAvailable());
                        System.out.println(rD.getAvailable());
                        break;
                    }
                }

            }
        }
    }
}
