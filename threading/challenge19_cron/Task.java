package challenge19_cron;

/**
 * Task
 */
public class Task implements Runnable{

    private final String message;
    private final int initialGapInSec, subSequentGapInSec;
    private long fireTime;

    public Task(String message, int initialGapInSec, int subSequentGapInSec){
        this.message = message;
        this.initialGapInSec = initialGapInSec;
        this.subSequentGapInSec = subSequentGapInSec;
        this.fireTime = System.currentTimeMillis() + initialGapInSec*100;
    }


    @Override
    public void run() {
        System.out.println(message);
    }

    public long getFireTime() {
        return fireTime;
    }

    public int getInitialGapInSec() {
        return initialGapInSec;
    }

    public int getSubSequentGapInSec() {
        return subSequentGapInSec;
    }

    public void setFireTime(long fireTime) {
        this.fireTime = fireTime;
    }

}