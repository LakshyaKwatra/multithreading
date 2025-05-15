package multithreading.synchronization.readerwriter;

public class ReaderWriterDemo {

    public static void demonstrateReaderWriter() {
        Document document = new Document();
        Thread readerThread1 = new Thread(null, new Reader(document), "Reader-1");
        Thread readerThread2 = new Thread(null, new Reader(document), "Reader-2");
        Thread readerThread3 = new Thread(null, new Reader(document), "Reader-3");
        Thread readerThread4 = new Thread(null, new Reader(document), "Reader-4");
        Thread readerThread5 = new Thread(null, new Reader(document), "Reader-5");
        Thread readerThread6 = new Thread(null, new Reader(document), "Reader-6");
        Thread writerThread = new Thread(new Writer(document));

        readerThread1.start();
        readerThread2.start();
        readerThread3.start();
        readerThread4.start();
        readerThread5.start();
        readerThread6.start();
        writerThread.start();


    }


}
