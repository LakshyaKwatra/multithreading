package multithreading.votecounter;

import multithreading.votecounter.model.Design;

public class VotesStreamRunnable implements Runnable{

    private final Design design;
    private boolean stop = false;

    public VotesStreamRunnable(Design design) {
        this.design = design;
    }

    @Override
    public void run() {
        while(!stop) {
            design.getVotes().add(1L);
            System.out.println("Added one vote to " + design.getName());

            int sleepTime =(int) (Math.random() * 1000);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public boolean getStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
