package multithreading.synchronization.barbershop;

public class Customer implements Runnable {

    private Barber barber;

    public Customer(Barber barber) {
        this.barber = barber;
    }

    @Override
    public void run() {
        try {
            barber.haircut();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
