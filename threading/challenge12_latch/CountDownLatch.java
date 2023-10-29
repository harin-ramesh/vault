package challenge12_latch;


class CountDownLatch {
    private int count;

    public CountDownLatch(int count){
        this.count = count;
    }

    public synchronized void await() throws InterruptedException {
        while (count > 0) {
            System.out.println(Thread.currentThread().getName()+" waiting");
            wait();
        }
        System.out.println(Thread.currentThread().getName()+"exit waiting");
    }

    public synchronized void countDown() {
        count--;
        if (count == 0) notifyAll();
        System.out.println(Thread.currentThread().getName()+" decreased count");
    }

    
}