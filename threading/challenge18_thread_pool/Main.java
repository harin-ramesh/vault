package challenge18_thread_pool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Main
 */
public class Main {

    public static void main(String args[]) throws InterruptedException, ExecutionException {

        ThreadPool threadPool = new ThreadPool(3);
        List<FutureTask<Integer>> futureTasks = new ArrayList<>();

        threadPool.submitTask(new Thrower());
        threadPool.submitTask(new Thrower());
        threadPool.submitTask(new Thrower());


        for(int i=0; i <10; i++) {
            FutureTask<Integer> ft = threadPool.submitTask(new Task(i+1));
            futureTasks.add(ft);
        }
        
        int res;
        for(FutureTask<Integer> ft: futureTasks){
            res = ft.get();
            System.out.println(res);
        }
        threadPool.shutDown();
    }
}