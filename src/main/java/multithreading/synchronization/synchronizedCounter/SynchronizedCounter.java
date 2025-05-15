package multithreading.synchronization.synchronizedCounter;

public class SynchronizedCounter {

    private int count;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
