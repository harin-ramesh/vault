package challenge19_cron;

import java.util.Set;
import java.util.concurrent.BlockingQueue;


/**
 * Worker
 */
public class Worker implements Runnable{

    private final int id;
    private final BlockingQueue<Task> taskQueue;

    public Worker(int id, BlockingQueue<Task> taskQueue) {
        this.id = id;
        this.taskQueue = taskQueue;
    }

    @Override
    public void run() {
        while (true) {
            Task task = null;
            try {
                task =  taskQueue.take();
                long curr = System.currentTimeMillis();
                if (curr >= task.getFireTime()) {
                    System.out.println(curr+" | "+task.getFireTime());
                    task.run();
                    if (task.getSubSequentGapInSec() > 0) {
                        task.setFireTime(System.currentTimeMillis() + task.getSubSequentGapInSec()*1000);
                        this.taskQueue.put(task);
                    }
                } else {
                    this.taskQueue.put(task);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }   
        }
    }
}