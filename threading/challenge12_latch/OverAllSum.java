package challenge12_latch;


public class OverAllSum {
    private int val;

    public OverAllSum() {
        this.val = 0;
    }

    public synchronized void add(int x){
        this.val += x;
    }

    public synchronized int getVal(){
        return this.val;
    }

}