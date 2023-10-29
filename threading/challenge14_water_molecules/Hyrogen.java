package challenge14_water_molecules;

/**
 * Hyrogen
 */
public class Hyrogen implements Runnable{

    private H20Semaphore h20Semaphore;

    public Hyrogen(H20Semaphore h20Semaphore) {
        this.h20Semaphore = h20Semaphore;
    }

    @Override
    public void run(){
        try {
            h20Semaphore.acquireH();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.print("H");
        h20Semaphore.releaseH();
    }    
}