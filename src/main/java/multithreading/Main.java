package multithreading;

import multithreading.sample.SampleDemo;
import multithreading.scoreaverage.ScoreAverageDemo;
import multithreading.synchronization.barbershop.BarberShopDemo;
import multithreading.synchronization.diningphilosophers.DiningPhilosophersDemo;
import multithreading.synchronization.printer.PrinterDemo;
import multithreading.synchronization.producerconsumer.ProducerConsumerDemo;
import multithreading.synchronization.readerwriter.ReaderWriterDemo;
import multithreading.synchronization.synchronizedCounter.SynchronizedCounterDemo;
import multithreading.synchronization.trafficlightcontroller.TrafficLightControllerDemo;
import multithreading.votecounter.VoteCounterDemo;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        SampleDemo.demonstrateThreadCreationAndExecution(5);
        SampleDemo.demonstrateThreadCreationAndExecutionWithRunnable(5);
        SampleDemo.demonstrateSleep();
        SampleDemo.demonstrateThreadInterruption();

        ScoreAverageDemo.demonstrateWait();

        VoteCounterDemo.voteAndCount();

        SynchronizedCounterDemo.demoSynchronizedKeyword();

        ProducerConsumerDemo.demonstrateProducerConsumer();

        TrafficLightControllerDemo.demonstrateTrafficLightController();

        DiningPhilosophersDemo.demonstrateDiningPhilosophers();

        ReaderWriterDemo.demonstrateReaderWriter();

        BarberShopDemo.demonstrateBarberShop();

        PrinterDemo.demonstratePrinter();
    }
}