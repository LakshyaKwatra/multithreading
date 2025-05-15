package multithreading.synchronization.trafficlightcontroller;

public class GreenLight {

    private Direction currentTurn = Direction.NORTH_SOUTH;
    private final int timer = 5000;

    public void setGreen(Direction direction) throws InterruptedException {

        synchronized (this) {
            while (currentTurn != direction) {
                wait();
            }
            System.out.println("Green Light is turned ON for: " + Thread.currentThread().getName());
            Thread.sleep(timer);
            System.out.println("Green Light is turned OFF for: " + Thread.currentThread().getName());
            currentTurn = getNextDirection(direction);
            notifyAll();
        }
    }

    private Direction getNextDirection(Direction direction) {
        switch (direction) {
            case NORTH_SOUTH:
                return Direction.EAST_WEST;
            case EAST_WEST:
                return Direction.PEDESTRIAN;
            case PEDESTRIAN:
                return Direction.NORTH_SOUTH;
            default:
                throw new IllegalArgumentException("Invalid direction");
        }
    }
}
