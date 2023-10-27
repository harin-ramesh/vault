package challenge11_read_write_lock;


public class ReadWriteLock {
    private int writer, reader;

    public ReadWriteLock(){
        this.writer = 0;
        this.reader = 0;
    }

    public synchronized void lockRead() throws InterruptedException {
        while (writer > 0) {
            System.out.println("read denied for read worker");
            wait();
        }
        reader++;
    }

    public synchronized void lockWrite() throws InterruptedException {
        while (reader > 0 || writer > 0) {
            wait();
        }
        writer++;
    }

    public synchronized void unlockRead() throws InterruptedException {
        reader--;
        notifyAll();
    }

    public synchronized void unlockWrite() throws InterruptedException {
        writer--;
        notifyAll();
    }

}
