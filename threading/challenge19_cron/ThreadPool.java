package challenge19_cron;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * ThreadPool
 */
public class ThreadPool {

    private boolean hasShutDown;
    private final int numThreads;
    private final List<Thread> threads;
    private final PriorityBlockingQueue<Task> taskQueue;


    public ThreadPool(int numThreads){
        this.numThreads = numThreads;
        this.taskQueue = new PriorityBlockingQueue<>(10, new Comparator<Task>() {

            @Override
            public int compare(Task o1, Task o2) {
                long diff = o1.getFireTime() - o2.getFireTime();
                if (diff > 0) return 1;
                return 0;
            }
            
        });
        this.threads = new ArrayList<>();

        for (int i=0; i < numThreads; i++) {
            Thread t = new Thread(new Worker(i, taskQueue));
            threads.add(t);
        }
        for (Thread thread: threads) thread.start();
        this.hasShutDown = false;
    }

    public synchronized void submitTask(Task task) throws InterruptedException {
        if (this.hasShutDown) throw new RuntimeException("Shutting down");
        this.taskQueue.put(task);
    }

}