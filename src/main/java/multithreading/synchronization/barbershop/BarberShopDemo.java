package multithreading.synchronization.barbershop;

public class BarberShopDemo {

    public static void demonstrateBarberShop() {
        Barber barber = new Barber();
        int customerArrivalTimer = 1000;

        int i = 1;
        while(true) {
            Thread customer = new Thread(null, new Customer(barber), "Customer-" + i);
            customer.start();
            try {
                Thread.sleep(customerArrivalTimer);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            i++;
        }
    }
}
