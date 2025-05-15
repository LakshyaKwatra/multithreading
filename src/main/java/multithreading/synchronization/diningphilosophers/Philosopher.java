package multithreading.synchronization.diningphilosophers;

public class Philosopher implements Runnable {

    private static final int MAX_EATING_PHILOSOPHERS = 4;
    private static int currentEatingPhilosophers = 0;
    private static final Object eatingLock = new Object(); // shared lock

    private final int id;
    private Fork leftFork;
    private Fork rightFork;

    public Philosopher(int id, Fork leftFork, Fork rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        while (true) {
            try {
                think();
                acquireForks();
                eat();
                releaseForks();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void think() throws InterruptedException {
        System.out.println("Philosopher - "+ id + ": Thinking...");
        Thread.sleep(1000);
    }

    private void eat() throws InterruptedException {
        System.out.println("Philosopher - "+ id + ": Eating");
        Thread.sleep(1000);
    }

    private void acquireForks() throws InterruptedException {
        synchronized (eatingLock) {
            while (currentEatingPhilosophers >= MAX_EATING_PHILOSOPHERS) {
                eatingLock.wait(); // wait on eating lock to be released
            }
            currentEatingPhilosophers++;
        }

        System.out.println("Current Eating philosophers increased to: " + currentEatingPhilosophers);
        leftFork.pickUp();
        System.out.println("Philosopher - " + id + ": Picked Up " + leftFork.getId());
        rightFork.pickUp();
        System.out.println("Philosopher - " + id + ": Picked Up " + rightFork.getId());
    }

    private void releaseForks() {

        leftFork.putDown();
        System.out.println("Philosopher - "+ id + ": Put Down " + leftFork.getId());
        rightFork.putDown();
        System.out.println("Philosopher - "+ id + ": Put Down " + rightFork.getId());
        synchronized (eatingLock) {
            currentEatingPhilosophers--;
            System.out.println("Current Eating philosophers decreased to: " + currentEatingPhilosophers);
            eatingLock.notifyAll();
        }
    }


}
