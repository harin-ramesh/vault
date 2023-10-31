package challenge18_thread_pool;

import java.util.List;
import java.util.Set;
import java.util.concurrent.BlockingQueue;

/**
 * BookKeeper
 */
public class BookKeeper implements Runnable {

    private final Set<Integer> deadThreads;
    private final List<Thread> threads;
    private final BlockingQueue<Runnable> taskQueue;

    public BookKeeper(Set<Integer> deadThreads, List<Thread> threads, BlockingQueue<Runnable> taskQueue) {
        this.deadThreads = deadThreads;
        this.threads = threads;
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            synchronized(deadThreads) {
                while (deadThreads.isEmpty()) {
                    try {
                        deadThreads.wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                for(Integer id: deadThreads) {
                    Thread th = new Thread(new Worker(id, taskQueue, deadThreads));
                    deadThreads.remove(id);
                    threads.set(id, th);
                    th.start();
                }
            }
        }
    }
    
}