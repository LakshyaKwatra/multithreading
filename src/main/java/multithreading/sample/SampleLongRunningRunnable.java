package multithreading.sample;

public class SampleLongRunningRunnable implements Runnable{

    @Override
    public void run() {
        for(int i = 1; i <= 100; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("[LongRunningTask Thread] Interrupted flag value inside the catch block: " + Thread.currentThread().isInterrupted());
                break;
            }
        }
    }
}
