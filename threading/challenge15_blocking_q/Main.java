package challenge15_blocking_q;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) {
        SimpleBlockingQueue q = new SimpleBlockingQueue(5);
        Thread p = new Thread(new Producer(q));
        Thread c = new Thread(new Consumer(q));

        p.start();
        c.start();
    }
}