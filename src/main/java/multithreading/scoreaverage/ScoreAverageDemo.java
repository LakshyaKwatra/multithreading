package multithreading.scoreaverage;

public class ScoreAverageDemo {

    public static void demonstrateWait() throws InterruptedException {
        int[] scores = new int[10];
        Thread scoresStreamThread = new Thread(new ScoreStreamRunnable(scores));
        Thread averageScoreThread = new Thread(new ScoreAverageRunnable(scores));

        scoresStreamThread.start();
        scoresStreamThread.join(); // this makes the main thread to wait for scoresStreamThread to terminate
        averageScoreThread.start(); // this thread only gets started once the scoresStreamThread terminates

    }
}
