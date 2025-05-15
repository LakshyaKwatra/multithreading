package multithreading.synchronization.trafficlightcontroller;

public class EastWestTrafficLight implements Runnable {

    private GreenLight greenLight;

    public EastWestTrafficLight(GreenLight greenLight) {
        this.greenLight = greenLight;
    }

    @Override
    public void run() {
        while(true) {
            try {
                greenLight.setGreen(Direction.EAST_WEST);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
