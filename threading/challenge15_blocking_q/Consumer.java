package challenge15_blocking_q;


public class Consumer implements Runnable {

    SimpleBlockingQueue queue;

	public Consumer(SimpleBlockingQueue queue){
        this.queue = queue;
	}

    @Override
    public void run(){
        int val;
        while(true) {
            try {
                val = queue.take();
                if (val == -1) break;
                System.out.println("Consumer consumed " + val);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
