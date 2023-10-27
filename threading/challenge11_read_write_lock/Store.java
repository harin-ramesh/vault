package challenge11_read_write_lock;


/**
 * Store
 */
public class Store {

    private volatile String name;
    private final ReadWriteLock lock;
    
    public Store(ReadWriteLock lock){
        this.lock = lock;
        this.name = "ABC STORE";
    }

    public String read() throws InterruptedException {
        lock.lockRead();
        try {
            return name;
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            lock.unlockRead();
        }
    }

    public void write() throws InterruptedException {
        lock.lockWrite();
        try {
            name += " extra";

        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            lock.unlockWrite();
        }
    }
}