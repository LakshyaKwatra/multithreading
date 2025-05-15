package multithreading.scoreaverage;

public class ScoreStreamRunnable implements Runnable {

    private final int[] scores;

    public ScoreStreamRunnable(int[] scores) {
        this.scores = scores;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            double score = Math.random() * 100;
            scores[i] = (int) score;
            System.out.println("score added to stream: " + scores[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
