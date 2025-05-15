package multithreading.sample;

public class SampleThread extends Thread {
    private final int id;

    public SampleThread(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println("Thread-"+ id + ": " + i);
        }
    }
}
