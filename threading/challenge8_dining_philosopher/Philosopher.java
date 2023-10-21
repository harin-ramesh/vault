package challenge8_dining_philosopher;


public class Philosopher implements Runnable{
    Chopstick left;
    Chopstick right;
    String name;

    public Philosopher(Chopstick left, Chopstick right, String name){
        this.left = left;
        this.right = right;
        this.name = name;
    }

    @Override
    public void run() {
        Chopstick c1;
        Chopstick c2;
    
        while(true) {

            // if (left.id < right.id){
            //     c1 = left;
            //     c2 = right;
            // } else {
            //     c1 = right;
            //     c2 = left;
            // }

            if (System.identityHashCode(left) < System.identityHashCode(right)){
                c1 = left;
                c2 = right;
            } else {
                c1 = right;
                c2 = left;
            }

            // In cases where System.identityHashCode(left) == System.identityHashCode(right) can cause deadlock
            // we can introduce a tielock, if hashcode is same thread take left lock first then right but before that it have to take lock on trielock obj.

            System.out.println(name + "is thinking...");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized(c1){
                System.out.println(name + "is thinking...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(c2){
                    System.out.println(name + " eating :)");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
