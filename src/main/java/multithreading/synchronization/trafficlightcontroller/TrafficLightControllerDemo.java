package multithreading.synchronization.trafficlightcontroller;

public class TrafficLightControllerDemo {

    public static void demonstrateTrafficLightController() {

        GreenLight greenLight = new GreenLight();

        Thread northSouthThread = new Thread(null, new NorthSouthTrafficLight(greenLight), "North South Traffic Light");
        Thread eastWestThread = new Thread(null, new EastWestTrafficLight(greenLight), "East West Traffic Light");
        Thread pedestrianCrossingThread = new Thread(null, new PedestrianTrafficLight(greenLight), "Pedestrian Crossing Traffic Light");

        northSouthThread.start();
        eastWestThread.start();
        pedestrianCrossingThread.start();
    }
}
