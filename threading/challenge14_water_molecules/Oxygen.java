package challenge14_water_molecules;

/**
 * Oxygen
 */
public class Oxygen implements Runnable{

    private H20Semaphore h20Semaphore;

    public Oxygen(H20Semaphore h20Semaphore) {
        this.h20Semaphore = h20Semaphore;
    }

    @Override
    public void run(){
        try {
            h20Semaphore.acquireO();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.print("O");
        h20Semaphore.releaseO();
    }    
}