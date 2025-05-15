package multithreading.votecounter;

import multithreading.votecounter.model.Design;

public class VoteCountRunnable implements Runnable {

    private final Design design;
    private boolean stop = false;

    public VoteCountRunnable(Design design) {
        this.design = design;
    }

    @Override
    public void run() {
        while(!stop) {
            System.out.println(design.getName() +" has " + design.getVotes().size() + " votes");
            try {
                Thread.sleep(2000);
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
