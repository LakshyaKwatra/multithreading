package multithreading.synchronization.producerconsumer;

public class Consumer implements Runnable{
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void consume() throws InterruptedException {
        while(true) {
            System.out.println("Consumer consumed: " + buffer.getValue());
            Thread.sleep(1000);
        }
    }

    @Override
    public void run() {
        try {
            consume();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
