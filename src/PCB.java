public class PCB {

    String name;
    int runtime;
    int access;
    int state;

    public void run(){
        this.runtime--;
        this.access--;

        if (runtime == 0) {
            this.state = 0;
        }
    }

    public PCB(String name, int runtime, int access) {
        this.name = name;
        this.runtime = runtime;
        this.access = access;
    }
}