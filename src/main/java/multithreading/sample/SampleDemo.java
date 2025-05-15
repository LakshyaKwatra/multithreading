package multithreading.sample;

public class SampleDemo {
    public static void demonstrateThreadCreationAndExecution(int count) {
        for(int i = 0; i < count; i++) {
            SampleThread sampleThread = new SampleThread(i);
            // if you call run(), the behaviour won't be multithreaded
            // as it will call the run() method in the current thread itself
            sampleThread.start();
        }
    }

    public static void demonstrateThreadCreationAndExecutionWithRunnable(int count) {
        SampleRunnable sampleRunnable = new SampleRunnable(); // encapsulates the running behaviour that a thread needs to execute
        for(int i = 0; i < count; i++) {
            Thread thread = new Thread(sampleRunnable);
            thread.start();
        }
    }

    public static void demonstrateSleep() {
        Thread threadToSleep = new Thread(() -> {
            for(int i = 0; i < 5; i++) {
                if(i == 4) {
                    try {
                        System.out.println("Sleeping for 2 seconds");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i + 1);
            }
        });
        threadToSleep.start();
    }

    public static void demonstrateThreadInterruption() throws InterruptedException {
        Thread longRunningTaskThread = new Thread(new SampleLongRunningRunnable());
        longRunningTaskThread.start(); // it will take 100 seconds to complete
        Thread.sleep(3000); // main thread waits for 3 seconds
        System.out.println("[Main Thread] Interrupted flag value before calling interrupt(): " + longRunningTaskThread.isInterrupted());
        longRunningTaskThread.interrupt(); // interrupt will be called in main thread on longRunningTaskThread
        System.out.println("[Main Thread] Interrupted flag value after calling interrupt(): " + longRunningTaskThread.isInterrupted());
    }
}
