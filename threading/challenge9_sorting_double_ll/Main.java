package challenge9_sorting_double_ll;


public class Main {

	public static int curr = 0;

	public static void main(String[] args) throws InterruptedException {
		DoublyLL dll = new DoublyLL();

		Thread t0 = new Thread(new Worker(100, dll));
		Thread t1 = new Thread(new Worker(0, dll));
		Thread t2 = new Thread(new Worker(400, dll));
		Thread t3 = new Thread(new Worker(2, dll));
		Thread t4 = new Thread(new Worker(999, dll));
		Thread t5 = new Thread(new Worker(4, dll));

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

		System.out.println("----------------------------------------\n");
		dll.traverse();
		System.out.println("----------------------------------------");

	}
}
