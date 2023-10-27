package challenge11_read_write_lock;

public class Main {

    public static void main(String[] args) throws InterruptedException{
        ReadWriteLock lock = new ReadWriteLock();
        Store store = new Store(lock);

        Thread r1 = new Thread(new Reader(store));
        Thread r2 = new Thread(new Reader(store));
        Thread r3 = new Thread(new Reader(store));
        Thread r4 = new Thread(new Reader(store));
        Thread r5 = new Thread(new Reader(store));
        Thread r6 = new Thread(new Reader(store));
        Thread w1 = new Thread(new Writer(store));

        r1.start();
        r2.start();
        r3.start();
        r4.start();
        r5.start();

        w1.start();

        r6.start();

        r1.join();
        r2.join();
        r3.join();
        r4.join();
        r5.join();
        r6.join();
        w1.join();

    }
}
