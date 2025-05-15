package multithreading.synchronization.diningphilosophers;

public class DiningPhilosophersDemo {

    public static void demonstrateDiningPhilosophers() {

        Fork fork1 = new Fork("Fork-1");
        Fork fork2 = new Fork("Fork-2");
        Fork fork3 = new Fork("Fork-3");
        Fork fork4 = new Fork("Fork-4");
        Fork fork5 = new Fork("Fork-5");

        Thread philosopher1 = new Thread(new Philosopher(1, fork1, fork2));
        Thread philosopher2 = new Thread(new Philosopher(2, fork2, fork3));
        Thread philosopher3 = new Thread(new Philosopher(3, fork3, fork4));
        Thread philosopher4 = new Thread(new Philosopher(4, fork4, fork5));
        Thread philosopher5 = new Thread(new Philosopher(5, fork5, fork1));

        philosopher1.start();
        philosopher2.start();
        philosopher3.start();
        philosopher4.start();
        philosopher5.start();

    }
}
