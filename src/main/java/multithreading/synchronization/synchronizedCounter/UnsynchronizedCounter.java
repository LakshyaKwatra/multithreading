package multithreading.synchronization.synchronizedCounter;

public class UnsynchronizedCounter {

    private int count;

    public void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
