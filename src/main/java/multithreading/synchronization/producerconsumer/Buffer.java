package multithreading.synchronization.producerconsumer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Buffer {
    private final Queue<Integer> queue = new LinkedList<>();
    private final int capacity;

    public Buffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void putValue(int value) throws InterruptedException {
        while(queue.size() == capacity) {
            wait();
        }
        queue.offer(value);
        System.out.println("Producer produced: " + queue.peek());
        notifyAll();
    }

    public synchronized int getValue() throws InterruptedException {
        while(queue.isEmpty()) {
            wait();
        }
        int value = queue.poll();
        notifyAll();
        return value;
    }
}
