package challenge12_latch;

import java.util.List;


public class Adder implements Runnable{
    private final int s, e;
    private final List<Integer> nums;
    private final CountDownLatch countDownLatch, getSetGo;
    private final OverAllSum overAllSum;

    public Adder(int s, int e, List<Integer> nums, CountDownLatch countDownLatch, OverAllSum overAllSum, CountDownLatch getSetGo){
        this.s = s;
        this.e = e;
        this.nums = nums;
        this.countDownLatch = countDownLatch;
        this.overAllSum = overAllSum; 
        this.getSetGo = getSetGo;
    }

    @Override
    public void run(){
        try {
            getSetGo.await();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        int a = 0;
        for(int i=s; i<=e; i++) {
            a += nums.get(i);
        }
        overAllSum.add(a);
        countDownLatch.countDown();
    }
}
