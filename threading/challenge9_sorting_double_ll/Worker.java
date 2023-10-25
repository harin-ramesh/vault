package challenge9_sorting_double_ll;


public class Worker implements Runnable {

    private final int num;
    private final DoublyLL dll;

	Worker(int num, DoublyLL dll){
        this.num = num;
        this.dll = dll;
	}

    @Override
    public void run(){
        dll.sortedInsertNaive(num);
    }
}
