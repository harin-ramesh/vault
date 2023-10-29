package challenge16_barrier;

/**
 * SimpleBarrier
 */
public class SimpleBarrier {

    private final int numThreads;
    private int count, exits;
    private final Runnable barrierTask;
    private boolean isReady;

    public SimpleBarrier(int numThreads, Runnable barrierTask){
        this.numThreads = numThreads;
        this.count = numThreads;
        this.barrierTask = barrierTask;
        this.isReady = true;
    }

    public synchronized void await() throws InterruptedException {
        while (!isReady) wait();
        count--;
        if (count > 0) {
            while(count > 0) wait();
        } else {
            barrierTask.run();
            isReady = false;
            notifyAll();
        }
        exits++;
        if (exits == numThreads) {
            count = numThreads;
            exits = 0;
            isReady = true;
            notifyAll();
        }
    }

}