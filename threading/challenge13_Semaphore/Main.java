package challenge13_Semaphore;


/**
 * Main
 */
public class Main {

    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(3);

        Thread t0 = new Thread(new CharPrinter('A', semaphore));
        Thread t1 = new Thread(new CharPrinter('B', semaphore));
        Thread t2 = new Thread(new CharPrinter('C', semaphore));
        Thread t3 = new Thread(new CharPrinter('D', semaphore));
        Thread t4 = new Thread(new CharPrinter('E', semaphore));
        Thread t5 = new Thread(new CharPrinter('F', semaphore));
        Thread t6 = new Thread(new CharPrinter('G', semaphore));
        Thread t7 = new Thread(new CharPrinter('H', semaphore));
        Thread t8 = new Thread(new CharPrinter('I', semaphore));
        Thread t9 = new Thread(new CharPrinter('J', semaphore));
        
        t0.start();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
    }

}