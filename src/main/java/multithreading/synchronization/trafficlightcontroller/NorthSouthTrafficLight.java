package multithreading.synchronization.trafficlightcontroller;

public class NorthSouthTrafficLight implements Runnable {

    private GreenLight greenLight;

    public NorthSouthTrafficLight(GreenLight greenLight) {
        this.greenLight = greenLight;
    }

    @Override
    public void run() {
        while(true) {
            try {
                greenLight.setGreen(Direction.NORTH_SOUTH);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
