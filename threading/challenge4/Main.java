package challenge4;


public class Main {

	public static int curr = 1;
	public static final int limit = 10;

	public static void main(String[] args) throws InterruptedException {
		Object lock = new Object();
		Thread t0 = new Thread(new OddWorker("odd-1", lock));
		Thread t1 = new Thread(new OddWorker("odd-2", lock));
		Thread t2 = new Thread(new EvenWorker("even-1", lock));
		Thread t3 = new Thread(new EvenWorker("even-2", lock));

		t0.start();
		t1.start();
		t2.start();
		t3.start();

		t0.join();
		t1.join();
		t2.join();
		t3.join();
	}
}
