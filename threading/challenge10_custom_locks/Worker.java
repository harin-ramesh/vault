package challenge10_custom_locks;


public class Worker implements Runnable {

    private final CustomLock lock;

	Worker(CustomLock lock){
        this.lock = lock;
	}

    @Override
    public void run(){
        try {
            lock.lock();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        lock.unlock();
    }
}
