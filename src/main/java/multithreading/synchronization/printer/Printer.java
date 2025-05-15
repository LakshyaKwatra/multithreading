package multithreading.synchronization.printer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Printer {

    private boolean inUse = false;
    private int printTimer = 0;

    private PriorityQueue<PrintJob> jobQueue = new PriorityQueue<>(Comparator.comparingInt(PrintJob::getPriority));

    public void print() {
        synchronized (this) {
            try {
                System.out.println("Printing started: ");
                while (inUse || jobQueue.isEmpty()) {
                    System.out.println("Printing started: ");
                    wait(); // Wait until a job is available and the printer is free
                }
                inUse = true;
                PrintJob printJob = jobQueue.poll();

                System.out.println("Printing started: " + printJob.getJobId());
                Thread.sleep(printTimer);
                System.out.println("Printing completed: " + printJob);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Printer job completed, release printer
            inUse = false;
            notify();
        }
    }

    public void createJob(PrintJob printJob) {
        synchronized (this) {
            jobQueue.offer(printJob);
            System.out.println("Job " + printJob.getJobId() + " added to the queue.");
            notifyAll();
        }
    }

}
