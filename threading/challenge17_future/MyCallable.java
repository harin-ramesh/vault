package challenge17_future;

import java.util.concurrent.Callable;

/**
 * MyCallable
 */
public class MyCallable  implements Callable<String>{

    @Override
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Hellow world";
    }

    
}