package multithreading.synchronization.barbershop;

public class Barber {

    private int numberOfCustomers;
    private static final int capacity = 5;
    private int haircutTimer = 2000;

    private boolean isOccupied = false;

    public void haircut() throws InterruptedException {
        synchronized (this) {
            System.out.println(Thread.currentThread().getName() + " reached the shop.");
            if(numberOfCustomers >= capacity) {
                System.out.println("Shop has no seats. " + Thread.currentThread().getName() + " left.");
                return;
            }
            numberOfCustomers++;
        }


        System.out.println(Thread.currentThread().getName() + " entered the shop.");

        synchronized (this) {
            while (isOccupied) {
                wait();
            }

            isOccupied = true;
            System.out.println("Started haircut of " + Thread.currentThread().getName());
        }

        Thread.sleep(haircutTimer);
        System.out.println("Finished haircut of " + Thread.currentThread().getName());

        synchronized (this) {
            numberOfCustomers--;
            isOccupied = false;
            notifyAll();
        }
    }

}
