package challenge2;


public class Worker implements Runnable {

    int var;
    int rounds;
    Object lock;

	Worker(int var, Object lock, int rounds){
        this.var = var;
        this.lock = lock;
        this.rounds = rounds;
	}

    @Override
    public void run(){
        // while (var == Main.curr){}
        while(rounds > 0){
            while(compare()) {} // above one is use because there can be context when that comparison is happening or a memory visibility issue.
            System.out.println(Main.curr);
            synchronized(lock){
                Main.curr = (Main.curr+1) % 6;
            }
            rounds--;
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
