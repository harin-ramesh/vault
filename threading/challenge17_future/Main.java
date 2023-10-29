package challenge17_future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> ft = new FutureTask<>(new MyCallable());
        new Thread(ft).start();
        System.out.println("Starteddddddd");
        String output = ft.get();
        System.out.println("Output: "+output);
    }
    
}