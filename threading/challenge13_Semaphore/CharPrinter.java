package challenge13_Semaphore;

/**
 * CharPrinter
 */
public class CharPrinter implements Runnable {
    private final char c;
    private final Semaphore semaphore;

    public CharPrinter(char c, Semaphore semaphore){
        this.c = c;
        this.semaphore = semaphore;
    }

    @Override
    public void run(){
        try {
            semaphore.acquire();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            for(int i=0; i < 10; i++) {
                System.out.print(c);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
        // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}