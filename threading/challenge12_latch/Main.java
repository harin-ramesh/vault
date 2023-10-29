package challenge12_latch;

import java.util.ArrayList;
import java.util.List;


public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        OverAllSum overAllSum = new OverAllSum();
        CountDownLatch countDownLatch = new CountDownLatch(4);
        CountDownLatch getSetGo = new CountDownLatch(1);
        List<Integer> nums = new ArrayList<Integer>();

        for(int i = 0; i < 100; i++){
            nums.add(i);
        }

        int size = 25;
        Thread g1 = new Thread(new Getter(overAllSum, countDownLatch));

        Thread a1 = new Thread(new Adder(0, size-1, nums, countDownLatch, overAllSum, getSetGo));
        Thread a2 = new Thread(new Adder(size, 2*size-1, nums, countDownLatch, overAllSum, getSetGo));
        Thread a3 = new Thread(new Adder(2*size, 3*size-1, nums, countDownLatch, overAllSum, getSetGo));
        Thread a4 = new Thread(new Adder(3*size, 4*size-1, nums, countDownLatch, overAllSum, getSetGo));

        g1.start();

        a1.start();
        a2.start();
        a3.start();
        a4.start();

        getSetGo.countDown(); // to start all adder thread at a time.

        g1.join();
        a1.join();
        a2.join();
        a3.join();
        a4.join();

    }

}
