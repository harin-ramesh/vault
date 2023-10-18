package challenge5;

import java.util.ArrayList;
import java.util.List;

public class Container {
    private final List<Integer> nums;
    private int curr;

    public Container(){
        this.nums = new ArrayList<Integer>();
        for(int i=0; i<=100; i++){
            this.nums.add(i);
        }
        this.curr = 0;
    }

    public synchronized int pluck() {
        if(this.curr == nums.size()){
            return -1;
        }
        int val = nums.get(curr);
        curr++;
        return val;
    }
}