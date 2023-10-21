package challenge6;


public class Worker implements Runnable {

    int var;
    int rounds;
    Object lock;

	Worker(int var, Object lock){
        this.var = var;
        this.lock = lock;
	}

    @Override
    public void run(){
        synchronized(lock){
            while(var != Main.curr) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Main.curr);
            Main.curr++;
            lock.notifyAll();
        }
    }
}
