package challenge10_custom_locks;


public class Main {

	public static int curr = 0;

	public static void main(String[] args) throws InterruptedException {

        CustomLock lock = new CustomLock();

		Thread t0 = new Thread(new Worker(lock));
		Thread t1 = new Thread(new Worker(lock));
		Thread t2 = new Thread(new Worker(lock));
		Thread t3 = new Thread(new Worker(lock));
		Thread t4 = new Thread(new Worker(lock));
		Thread t5 = new Thread(new Worker(lock));

		t0.start();
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		t0.join();
		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();

	}
}
