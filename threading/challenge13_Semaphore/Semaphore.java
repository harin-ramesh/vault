package challenge13_Semaphore;


public class Semaphore {

    private int permitsLeft;
    private final int maxPermits;

    public Semaphore(int maxPermits){
        if (maxPermits < 0) throw new RuntimeException("Max permits should be graeter than zero");
        this.maxPermits = maxPermits;
        this.permitsLeft = maxPermits;
    }

    public synchronized void acquire() throws InterruptedException {
        if (maxPermits < 0) throw new RuntimeException("Max < 0");
        while (permitsLeft == 0) {
            wait();
        }
        permitsLeft--;
    }

    public synchronized void release() {
        if (permitsLeft == maxPermits) throw new RuntimeException("Illegal call");
        permitsLeft++;
        if (permitsLeft == 1) notifyAll();
    }

}