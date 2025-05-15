package multithreading.synchronization.readerwriter;

public class Document {

    private String text = "";

    private int numberOfReaders = 0;
    private int numberOfWriters = 0;
    private int waitingWriters = 0;


    public synchronized void read() throws InterruptedException {
        while(numberOfWriters != 0 || waitingWriters > 0) {
            wait();
        }
        numberOfReaders++;
        System.out.println(Thread.currentThread().getName() + " reading text: " + text);
        numberOfReaders--;
        if(numberOfReaders == 0) {
            notifyAll();
        }
    }

    public synchronized void write(String value) throws InterruptedException {
        while(numberOfWriters != 0 || numberOfReaders != 0) {
            wait();
        }
        numberOfWriters++;
        text = text.concat(value);
        numberOfWriters--;
        if(numberOfWriters == 0) {
            notifyAll();
        }
    }

}
