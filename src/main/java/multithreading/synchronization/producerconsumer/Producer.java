package multithreading.synchronization.producerconsumer;

public class Producer implements Runnable{

    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void produce() throws InterruptedException {
        int value = 0;
        while(true) {
            buffer.putValue(value++);
            Thread.sleep(1000);
        }

    }

    @Override
    public void run() {
        try {
            produce();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
