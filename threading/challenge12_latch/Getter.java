package challenge12_latch;


public class Getter implements Runnable{

    private final OverAllSum overAllSum;
    private final CountDownLatch countDownLatch;

    public Getter(OverAllSum overAllSum, CountDownLatch countDownLatch){
        this.overAllSum = overAllSum;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            countDownLatch.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("SUM: " + overAllSum.getVal());
    }
    
}