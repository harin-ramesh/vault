package challenge5;


public class Main {

	static int curr = 0;

	public static void main(String[] args) throws InterruptedException {
		Object lock = new Object();
		Container container = new Container();

		Thread t0 = new Thread(new Worker(container, lock));
		Thread t1 = new Thread(new Worker(container, lock));
		Thread t2 = new Thread(new Worker(container, lock));
		Thread t3 = new Thread(new Worker(container, lock));

		t0.start();
		t1.start();
		t2.start();
		t3.start();

		t0.join();
		t1.join();
		t2.join();
		t3.join();

		System.out.println(Main.curr);
	}
}
