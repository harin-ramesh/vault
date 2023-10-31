package challenge19_cron;

import java.util.concurrent.ExecutionException;


/**
 * Main
 */
public class Main {

    public static void main(String args[]) throws InterruptedException, ExecutionException {

        ThreadPool threadPool = new ThreadPool(3);
        
        Task t1 = new Task("I love Java", 1, 0);
        Task t2 = new Task("I love Python", 2, 4);
        Task t3 = new Task("I love C", 5, 1);

        threadPool.submitTask(t1);
        threadPool.submitTask(t2);
        threadPool.submitTask(t3);

    }
}