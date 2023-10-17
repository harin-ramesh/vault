package challenge3;


public class Worker implements Runnable {

    int var;
    Object lock;

	Worker(int var, Object lock){
        this.var = var;
        this.lock = lock;
	}

    @Override
    public void run(){
        while(true) {
            while(compare()) {}
            synchronized(lock){
                if (Main.rounds == 0) break;
                System.out.println(Main.curr);
                Main.curr = (Main.curr+1) % 6;
                if (Main.curr == 0) Main.rounds--;
            }
        }
    }

    // compare is in synchronzyed block to avoid mempry visiblity issues.
    public boolean compare(){
        boolean ans = true;
        synchronized(lock){
            ans = !(var == Main.curr) && !(Main.rounds == 0);
        }
        return ans;
    }
}
