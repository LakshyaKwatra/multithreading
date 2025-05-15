package multithreading.synchronization.diningphilosophers;

public class Fork {

    private final String id;

    public boolean inUse = false;

    public Fork(String id) {
        this.id = id;
    }

    public synchronized void pickUp() throws InterruptedException {
        while(inUse) {
            wait();
        }
        inUse = true;
    }

    public synchronized void putDown() {
        inUse = false;
        notifyAll();
    }

    public String getId() {
        return id;
    }
}
