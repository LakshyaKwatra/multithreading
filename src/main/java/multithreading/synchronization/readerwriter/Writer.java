package multithreading.synchronization.readerwriter;

public class Writer implements Runnable {

    private Document document;

    public Writer(Document document) {
        this.document = document;
    }

    @Override
    public void run() {
        int i = 0;
        while(true) {
            i++;
            try {
                document.write(String.valueOf(i) + ", ");
                System.out.println("Added " + String.valueOf(i) + " to the document");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
