import java.util.HashMap;

public class Work {
    private String name;
    private boolean finish;

    public HashMap<Resource, Integer> resourceNeedMap;
    public HashMap<Resource, Integer> resourceUsedMap;
    public HashMap<Resource, Integer> resourceMaxMap;

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public String getName() {
        return name;
    }

    public Work(String name, HashMap<Resource, Integer> maxMap) {
        this.name = name;
        this.finish = false;
        this.resourceMaxMap = new HashMap<>();
        this.resourceNeedMap = new HashMap<>();
        this.resourceUsedMap = new HashMap<>();
        for (Resource r:
             maxMap.keySet()) {
            this.resourceMaxMap.put(r, maxMap.get(r));
            this.resourceUsedMap.put(r, 0);

        }
    }
}




































