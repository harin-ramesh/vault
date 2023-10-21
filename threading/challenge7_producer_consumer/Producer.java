package challenge7_producer_consumer;


public class Producer implements Runnable {

    Queue queue;

	public Producer(Queue queue){
        this.queue = queue;
	}

    @Override
    public void run(){
        for(int i=0; i<500; i++){
            synchronized(queue){
                while (queue.isFull()){
                    System.out.println("------");
                    System.out.println(queue.isFull());
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                queue.push(i);
                System.out.println("Producer added " + i);
                queue.notifyAll();
            }
        }

        synchronized(queue){
            if (queue.isFull()){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.push(-1);
            System.out.println("!!!!!!!!!!!  Producer added " + -1);
            queue.notifyAll();
        }
    }
}
