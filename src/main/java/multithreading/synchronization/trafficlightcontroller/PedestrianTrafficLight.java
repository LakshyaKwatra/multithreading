package multithreading.synchronization.trafficlightcontroller;

public class PedestrianTrafficLight implements Runnable {

    private GreenLight greenLight;

    public PedestrianTrafficLight(GreenLight greenLight) {
        this.greenLight = greenLight;
    }

    @Override
    public void run() {
        while(true) {
            try {
                greenLight.setGreen(Direction.PEDESTRIAN);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
