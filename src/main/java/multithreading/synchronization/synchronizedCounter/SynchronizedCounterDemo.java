package multithreading.synchronization.synchronizedCounter;

public class SynchronizedCounterDemo {


    public static void demoSynchronizedKeyword() {
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();
        UnsynchronizedCounter unsynchronizedCounter = new UnsynchronizedCounter();
        SynchronizedBlockCounter synchronizedBlockCounter = new SynchronizedBlockCounter();

        Thread t1 = new Thread(() -> {
            for(int i = 1; i <= 1000000; i++) {
                unsynchronizedCounter.increment();
                synchronizedCounter.increment();
                synchronizedBlockCounter.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 1; i <= 1000000; i++) {
                unsynchronizedCounter.increment();
                synchronizedCounter.increment();
                synchronizedBlockCounter.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Unsynchronized Counter Count: " + unsynchronizedCounter.getCount());
        System.out.println("Synchronized Counter Count: " + synchronizedCounter.getCount());
        System.out.println("Synchronized Block Counter Count: " + synchronizedBlockCounter.getCount());
        System.out.println("Synchronized Block Counter Unsynchronized Count: " + synchronizedBlockCounter.getUnsynchronizedCount());

    }
}
