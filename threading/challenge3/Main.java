package challenge3;


public class Main {

	public static int curr = 0;
	public static int rounds = 2;

	public static void main(String[] args) throws InterruptedException {
		Object lock = new Object();

		Thread t0 = new Thread(new Worker(0, lock));
		Thread t1 = new Thread(new Worker(5, lock));
		Thread t2 = new Thread(new Worker(1, lock));
		Thread t3 = new Thread(new Worker(2, lock));
		Thread t4 = new Thread(new Worker(3, lock));
		Thread t5 = new Thread(new Worker(4, lock));

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


// cmd + j -> to open and close bottom bar
// > save project -> to save project in project manager
// > edit project -> to update path or delete project from project manager
// shift + cmd + x -> extensions
// shift + cmd + E -> explorer
// shift + cmd + R -> remote explorer
// control + ` -> to open terminal
// cmd + shift + n -> new window
// cmd + m -> maximize window
