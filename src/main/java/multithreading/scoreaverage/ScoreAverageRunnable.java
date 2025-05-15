package multithreading.scoreaverage;

public class ScoreAverageRunnable implements Runnable {

    private final int[] scores;

    public ScoreAverageRunnable(int[] scores) {
        this.scores = scores;
    }

    @Override
    public void run() {
        int sum = 0;
        for(int s: scores) {
            sum += s;
        }
        int average = sum / 10;
        System.out.println("Average score: "+ average);
    }
}
