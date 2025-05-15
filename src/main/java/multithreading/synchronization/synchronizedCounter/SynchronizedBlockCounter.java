package multithreading.synchronization.synchronizedCounter;

public class SynchronizedBlockCounter {

    private int count;
    private int unsynchronizedCount;

    public void increment() {
        synchronized(this) {
            count++;
        }
        unsynchronizedCount++;
    }

    public int getCount() {
        return count;
    }

    public int getUnsynchronizedCount() {
        return unsynchronizedCount;
    }
}
