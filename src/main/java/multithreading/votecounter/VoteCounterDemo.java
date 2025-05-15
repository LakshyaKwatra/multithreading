package multithreading.votecounter;

import multithreading.votecounter.model.Design;

public class VoteCounterDemo {

    public static void voteAndCount() {
        Design design1 = new Design(1,"Design-1");

        VotesStreamRunnable votesStreamRunnable1 = new VotesStreamRunnable(design1);
        VoteCountRunnable voteCountRunnable1 = new VoteCountRunnable(design1);

        Thread votingThread1 = new Thread(votesStreamRunnable1);
        Thread countingThread1 = new Thread(voteCountRunnable1);

        votingThread1.start();
        countingThread1.start();

        Design design2 = new Design(2,"Design-2");

        VotesStreamRunnable votesStreamRunnable2 = new VotesStreamRunnable(design2);
        VoteCountRunnable voteCountRunnable2 = new VoteCountRunnable(design2);

        Thread votingThread2 = new Thread(votesStreamRunnable2);
        Thread countingThread2 = new Thread(voteCountRunnable2);

        votingThread2.start();
        countingThread2.start();

        Design design3 = new Design(3,"Design-3");

        VotesStreamRunnable votesStreamRunnable3 = new VotesStreamRunnable(design3);
        VoteCountRunnable voteCountRunnable3 = new VoteCountRunnable(design3);

        Thread votingThread3 = new Thread(votesStreamRunnable3);
        Thread countingThread3 = new Thread(voteCountRunnable3);

        votingThread3.start();
        countingThread3.start();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        votesStreamRunnable1.setStop(true);
        votesStreamRunnable2.setStop(true);
        votesStreamRunnable3.setStop(true);
        voteCountRunnable1.setStop(true);
        voteCountRunnable2.setStop(true);
        voteCountRunnable3.setStop(true);

        System.out.println("Final votes for "+ design1.getName() + ": " + design1.getVotes().size());
        System.out.println("Final votes for "+ design2.getName() + ": " + design2.getVotes().size());
        System.out.println("Final votes for "+ design3.getName() + ": " + design3.getVotes().size());

    }
}
