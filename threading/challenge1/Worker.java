package challenge1;


public class Worker implements Runnable {

    int var;
    int rounds;
    Object lock;

	Worker(int var, Object lock){
        this.var = var;
        this.lock = lock;
	}

    @Override
    public void run(){
        // while (var == Main.curr){}\
        while(compare()) {} // above one is use because there can be context when that comparison is happening or a memory visibility issue.
        System.out.println(Main.curr);
        synchronized(lock){
            Main.curr = (Main.curr+1);
        }
    }

    // compare is in synchronzyed block to avoid mempry visiblity issues.
    public boolean compare(){
        boolean ans = true;
        synchronized(lock){
            ans = (var != Main.curr);
        }
        return ans;
    }
}
