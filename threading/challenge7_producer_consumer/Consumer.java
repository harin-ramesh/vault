package challenge7_producer_consumer;


public class Consumer implements Runnable {

    Queue queue;

	public Consumer(Queue queue){
        this.queue = queue;
	}

    @Override
    public void run(){
        while(true) {
            synchronized(queue){
                while (queue.isEmpty() && Main.producer_count > 0){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                if (Main.producer_count == 0) {
                    queue.notifyAll();
                    break;
                }

                int val = queue.pop();
                System.out.println("Consumer consumed " + val);
                queue.notifyAll();
                if (val == -1) {
                    Main.producer_count--;
                }
            }
        }
    }
}
