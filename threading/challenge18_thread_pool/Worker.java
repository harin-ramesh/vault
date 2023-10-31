package challenge18_thread_pool;

import java.util.Set;
import java.util.concurrent.BlockingQueue;


/**
 * Worker
 */
public class Worker implements Runnable{

    private final int id;
    private final Set<Integer> deadThreads;
    private final BlockingQueue<Runnable> taskQueue;

    public Worker(int id, BlockingQueue<Runnable> taskQueue, Set<Integer> deadThreads) {
        this.id = id;
        this.taskQueue = taskQueue;
        this.deadThreads = deadThreads;
    }

    @Override
    public void run() {
        while (true) {
            try {
                taskQueue.take().run();
            } catch (Exception e) {
                if ("Shutting down threads".equals(e.getMessage())){
                    break;
                }
                synchronized(deadThreads){
                    deadThreads.add(id);
                    deadThreads.notifyAll();
                }
                System.out.println("worker diedddddddd");
                throw new RuntimeException(e);
            }   
        }
        System.out.println("Thread shutiinh down ............");
    }
}