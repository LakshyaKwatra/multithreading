package multithreading.synchronization.printer;

public class PrinterDemo {

    public static void demonstratePrinter() {

        Printer printer = new Printer(); // printer resource

        Thread printerThread = new Thread(() -> {
            while (true) {
                printer.print();
            }
        }); // printer worker thread
        printerThread.start();

        Thread jobThread1 = new Thread(() -> {
            int i = 1;
            while(true) {
                PrintJob job = new PrintJob(i, (int) (1 + Math.random() * 9));
                printer.createJob(job);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                i++;
            }
        });

        Thread jobThread2 = new Thread(() -> {
            int i = 1000;
            while(true) {
                PrintJob job = new PrintJob(i, (int) (Math.random() * 10));
                printer.createJob(job);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                i++;
            }
        });

        Thread jobThread3 = new Thread(() -> {
            int i = 1000000;
            while(true) {
                PrintJob job = new PrintJob(i, (int) (Math.random() * 10));
                printer.createJob(job);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                i++;
            }
        });

        jobThread1.start();
        jobThread2.start();
        jobThread3.start();
    }

}
