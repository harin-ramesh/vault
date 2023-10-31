package challenge18_thread_pool;


/**
 * Shutter
 */
public class Shutter implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException("Shutting down threads");
    }

}