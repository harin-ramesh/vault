package challenge11_read_write_lock;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteLock {
    // private int writer, reader
    private int writerEntryCount, writeReq;
    private final Map<Thread, Integer> entryCount;
    private Thread writerThread;

    public ReadWriteLock(){
        this.writerEntryCount = 0;
        // this.reader = 0;
        this.writeReq = 0;
        this.entryCount = new HashMap<Thread, Integer>();
        this.writerThread = null;
    }

    // writeReq -> this variable helps to block new readers who are comming after a reader requests a read read operaton and is still wiating. 
    // This is to avoid writer stravation becayse if read lock
    // In case a thread take lock and sleep some time then context switch happens and writer comes and tries to take but won;t be able to do that
    // since reader have the lock, so reader will increment writeReq and wait. reader will again will get the control. lets assume reader is trying to 
    // lock again (re entrant lock) but won't able to because of writeReq, thus this sitation result in dead lock

    // public synchronized void lockRead() throws InterruptedException {
    //     while (writer > 0 || writeReq > 0) {
    //         System.out.println("read denied for read worker");
    //         wait();
    //     }
    //     reader++;
    // }

    public synchronized void lockRead() throws InterruptedException {
        while (!allowReadAccess()) {
            System.out.println(Thread.currentThread().getName()+" read denied for read worker");
            wait();
        }
        System.out.println(Thread.currentThread().getName()+" acquired read lock");
        Integer count = entryCount.getOrDefault(Thread.currentThread(), 0);
        entryCount.put(Thread.currentThread(), count+1);
    }

    // public synchronized void unlockRead() throws InterruptedException {
    //     reader--;
    //     notifyAll();
    // }

    public synchronized void unlockRead() throws InterruptedException {
        if (!entryCount.containsKey(Thread.currentThread())){
            throw new RuntimeException("Illegal unlock call");
        }
        Integer count = entryCount.get(Thread.currentThread());
        System.out.println(Thread.currentThread().getName()+" released read lock");
        if (count > 1) {
            entryCount.put(Thread.currentThread(), count-1);
        } else {
            entryCount.remove(Thread.currentThread());
            notifyAll();
        }
    }

    // This write lock doen't support re entrancy
    // public synchronized void lockWrite() throws InterruptedException {

    //     writeReq++;
    //     while (reader > 0 || writer > 0) {
    //         wait();
    //     }
    //     writeReq--;
    //     writer++;
    // }


    public synchronized void lockWrite() throws InterruptedException {
        writeReq++;
        while (!allowWriteAccess()) {
            wait();
        }
        writeReq--;
        writerThread = Thread.currentThread();
        writerEntryCount++;
        System.out.println(Thread.currentThread().getName()+" acquired write lock");
    }


    // public synchronized void unlockWrite() throws InterruptedException {
    //     writerEntryCount--;
    //     notifyAll();
    // }

    public synchronized void unlockWrite() throws InterruptedException {
        if (!Thread.currentThread().equals(writerThread)) throw new RuntimeException("Invalid unlock call");
        writerEntryCount--;
        System.out.println(Thread.currentThread().getName()+" release wrtite lock");
        if(writerEntryCount == 0){
            writerThread = null;
            notifyAll();
        }
    }


    private boolean allowReadAccess(){
        if (Thread.currentThread().equals(writerThread)) return true; // when a thread with write access trying to get read lock, this should be the first as writerEntryCount > 0
        if (writerEntryCount > 0) return false;
        if (entryCount.containsKey(Thread.currentThread())) return true;  // for re entranct
        if (writeReq > 0) return false;
        return true;
    }

    private boolean allowWriteAccess(){
        if ( entryCount.size() == 1 && entryCount.get(Thread.currentThread()) != null) return true; // Updagrade read lock to write
        if (entryCount.size() > 0) return false;
        if (writerThread == null) return true;
        if (writerThread.equals(Thread.currentThread())) return true; // for re entranct
        return false;
    }

}
