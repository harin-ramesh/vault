package challenge7_producer_consumer;


public class Main {

	public static int producer_count = 2;

	public static void main(String[] args) throws InterruptedException {

		Queue queue = new Queue(50);

		Thread producer1 = new Thread(new Producer(queue));
		Thread producer2 = new Thread(new Producer(queue));
		// Thread producer3 = new Thread(new Producer(queue));
		// Thread producer4 = new Thread(new Producer(queue));

		Thread consumer1 = new Thread(new Consumer(queue));
		Thread consumer2 = new Thread(new Consumer(queue));
		Thread consumer3 = new Thread(new Consumer(queue));

		producer1.start();
		producer2.start();
		// producer3.start();
		// producer4.start();

		consumer1.start();
		consumer2.start();
		consumer3.start();

		producer1.join();
		producer2.join();
		// producer3.join();
		// producer4.join();

		consumer1.join();
		consumer2.join();
		consumer3.join();

	}
}
