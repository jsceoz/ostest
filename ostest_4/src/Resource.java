public class Resource {
    private String name;
    private int total;
    private int available;
    private int used;

    public String getName() {
        return name;
    }

    public int getTotal() {
        return total;
    }

    public int getAvailable() {
        return available;
    }

    public int getUsed() {
        return used;
    }

    public void allocate(Work work, Integer num) {
        this.available -= num;
        this.used += num;
        Integer newNum = work.resourceUsedMap.get(this) + num;
        work.resourceUsedMap.put(this, newNum);
        work.resourceNeedMap.put(this, work.resourceMaxMap.get(this) - newNum);
    }

    public void retake(Work work) {
        this.available += work.resourceUsedMap.get(this);
        work.resourceNeedMap.put(this, 0);
        work.resourceMaxMap.put(this, 0);
        work.setFinish(true);
    }



    public Resource(String name, int total) {
        this.name = name;
        this.total = total;
        this.available = total;
        this.used = 0;
    }
}
