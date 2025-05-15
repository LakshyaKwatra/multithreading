package multithreading.synchronization.printer;

public class PrintJob {

    private int jobId;
    private int priority; // lower number means higher priority


    public PrintJob(int jobId, int priority) {
        this.jobId = jobId;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Job ID: " + jobId + " | " + "Priority: " + priority;
    }

    public int getPriority() {
        return priority;
    }

    public int getJobId() {
        return jobId;
    }
}
