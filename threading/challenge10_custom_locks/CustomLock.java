package challenge10_custom_locks;


public class CustomLock {

    private boolean isLocked;
    private Thread lockedBy;
    private int count;

	public CustomLock(){
        this.isLocked = false;
        this.lockedBy = null;
        this.count = 0;
	}

    public synchronized void lock() throws InterruptedException {
        //  !lockedBy.equals(Thread.currentThread() for re entrancy
        while(isLocked && !lockedBy.equals(Thread.currentThread()) ){
            System.out.println(Thread.currentThread().getName() + " need to wait");
            wait();
        }
        count++;
        isLocked = true;
        lockedBy = Thread.currentThread();
        System.out.println(Thread.currentThread().getName() + " lock acquired");
    }

    public synchronized void unlock() {
        if (!isLocked){
            throw new RuntimeException("trying to unlock without locking");
        }
        if (!lockedBy.equals(Thread.currentThread())){
            throw new RuntimeException("This thread don't hold lock");
        }
        count --;
        if (count == 0) {
            isLocked = false;
            lockedBy = null;
            notifyAll();
        }
        System.out.println(Thread.currentThread().getName() + " lock released");
    }

}