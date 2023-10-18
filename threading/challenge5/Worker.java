package challenge5;


public class Worker implements Runnable {
    Object lock;
    Container container;

    public Worker(Container container, Object lock){
        this.lock = lock;
        this.container = container;
    }

    @Override
    public void run(){
        while(true){
            synchronized(lock){
                int x = container.pluck();
                if (x==-1) break;
                Main.curr += x;               
            }
        }
    }
}