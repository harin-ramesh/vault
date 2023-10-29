package challenge14_water_molecules;


public class H20Semaphore {

    private int hCount, oCount;
    private int releaseHCount, releaseOCount;

    public H20Semaphore(){
        this.hCount = 2;
        this.oCount = 1;
        this.releaseHCount = 0;
        this.releaseOCount = 0;
    }

    public synchronized void acquireH() throws InterruptedException {
        if (hCount < 0) throw new RuntimeException("hCount < 0");
        while (hCount == 0) {
            wait();
        }
        hCount--;
    }

    public synchronized void acquireO() throws InterruptedException {
        if (oCount < 0) throw new RuntimeException("hCount < 0");
        while (oCount == 0) {
            wait();
        }
        oCount--;
    }

    public synchronized void releaseH() {
        releaseHCount++;
        if (releaseHCount == 2 && releaseOCount == 1){
            hCount = 2;
            oCount = 1;
            releaseHCount = 0;
            releaseOCount = 0;
            notifyAll();
        }
    }

    public synchronized void releaseO() {
        releaseOCount++;
        if (releaseHCount == 2 && releaseOCount == 1){
            hCount = 2;
            oCount = 1;
            releaseHCount = 0;
            releaseOCount = 0;
            notifyAll();
        }
    }
}