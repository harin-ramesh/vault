package challenge15_blocking_q;


public class Producer implements Runnable {

    SimpleBlockingQueue queue;

	public Producer(SimpleBlockingQueue queue){
        this.queue = queue;
	}

    @Override
    public void run(){
        for(int i=0; i<500; i++){
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("Producer added " + i);
        }
        try {
            queue.put(-1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("!!!!!!!!!!!  Producer added " + -1);        
    }
}
