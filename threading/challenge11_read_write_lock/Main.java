package challenge11_read_write_lock;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        ReadWriteLock lock = new ReadWriteLock();
        Store store = new Store(lock);

        Thread r1 = new Thread(new Reader(store));
        Thread r2 = new Thread(new Reader(store));

        // Thread w1 = new Thread(new Writer(store));

        r1.start();
        r2.start();
        // w1.start();

        r1.join();        
        r2.join();
        // w1.join();

        // when two reader threads  tries to updgrade lock to write lock it can lead to deadlock, to acquire dead lock one has to release read lock.
        // so while upgrading lock, best practice is release the current lock.

    }
}
