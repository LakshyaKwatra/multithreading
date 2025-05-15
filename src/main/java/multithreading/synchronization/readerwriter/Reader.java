package multithreading.synchronization.readerwriter;

public class Reader implements Runnable {

    private Document document;

    public Reader(Document document) {
        this.document = document;
    }

    @Override
    public void run() {
        while(true) {
            try {
                document.read();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
