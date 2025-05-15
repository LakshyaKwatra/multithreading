package multithreading.synchronization.producerconsumer;

public class ProducerConsumerDemo {

    public static void demonstrateProducerConsumer() {
        Buffer buffer = new Buffer(10);
        Thread producerThread = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();
    }



}
