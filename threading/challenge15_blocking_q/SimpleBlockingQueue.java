package challenge15_blocking_q;

import java.util.LinkedList;


/**
 * SimpleBlockingQueue
 */
public class SimpleBlockingQueue {

    private final LinkedList<Integer> queue;
    private final int capacity;

    public SimpleBlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public synchronized int take() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        if (queue.size() == capacity) notifyAll();
        int x = queue.poll();
        return x;
    }

    public synchronized void put(Integer val) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(val);
        if (queue.size() == 1) notifyAll();
    }
}