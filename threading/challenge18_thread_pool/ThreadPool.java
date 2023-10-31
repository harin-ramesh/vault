package challenge18_thread_pool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * ThreadPool
 */
public class ThreadPool {

    private boolean hasShutDown;
    private final int numThreads;
    private final List<Thread> threads;
    private final BlockingQueue<Runnable> taskQueue;
    private final Thread bookKeeper;
    private final Set<Integer> deadThreads;

    public ThreadPool(int numThreads){
        this.numThreads = numThreads;
        this.taskQueue = new ArrayBlockingQueue<Runnable>(10) ;
        this.threads = new ArrayList<>();
        this.deadThreads = new HashSet<>();

        for (int i=0; i < numThreads; i++) {
            Thread t = new Thread(new Worker(1, taskQueue, this.deadThreads));
            threads.add(t);
        }
        for (Thread thread: threads) thread.start();
        this.hasShutDown = false;
        this.bookKeeper = new Thread(new BookKeeper(deadThreads, threads, taskQueue));
        this.bookKeeper.start();
    }

    // Since bookkeeper is running this program won't terminate, a counter can be indroduced to count active task
    // this active can be decreased when a task is finished
    // bookkeeper thread can exit when this count is zero.

    // Future task is runnable
    // Future task takes a callable
    // this how we convert callable to runnable, pass it to Future task
    public synchronized FutureTask<Integer> submitTask(Callable<Integer> callable) throws InterruptedException {
        if (this.hasShutDown) throw new RuntimeException("Shutting down");
        FutureTask<Integer> ft = new FutureTask<Integer>(callable);
        this.taskQueue.put(ft);
        return ft;
    }

    public synchronized void submitTask(Runnable runnable) throws InterruptedException {
        if (this.hasShutDown) throw new RuntimeException("Shutting down");
        this.taskQueue.put(runnable);
    }

    public synchronized void shutDown() throws InterruptedException{
        this.hasShutDown = true;
        for (int i=0; i < numThreads; i++) {
            this.taskQueue.put(new Shutter());
        }
    }

}