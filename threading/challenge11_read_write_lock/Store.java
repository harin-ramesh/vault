package challenge11_read_write_lock;


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
            Thread.sleep(5000);
            String val = name;
            log(val);
            return val;
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
            System.out.println(Thread.currentThread().getName() + "Writesss");
            foo();
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            lock.unlockWrite();
        }
    }

    public void foo() throws InterruptedException{
        lock.lockRead();
        System.out.println(Thread.currentThread().getName() + "Inside fooooooooo");
        lock.unlockRead();
    }

    public void log(String val) throws InterruptedException {
        lock.lockWrite();
        try {
            System.out.println(Thread.currentThread().getName() + " Found name to be: " + val);
        } catch (Exception e) {

        } finally {
            lock.unlockWrite();
        }
    }
}
