package challenge18_thread_pool;

import java.util.concurrent.Callable;

/**
 * Task
 */
public class Task implements Callable<Integer>{

    private int x;

    public Task(int x){
        this.x = x;
    }

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2*x;
    }

}