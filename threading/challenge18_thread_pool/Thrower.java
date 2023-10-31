package challenge18_thread_pool;

/**
 * Thrower
 */
public class Thrower implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        throw new RuntimeException("Thrower throwing exceptionnnnnnnnn..............");
    }

}