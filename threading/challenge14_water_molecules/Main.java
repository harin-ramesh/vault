package challenge14_water_molecules;

import java.util.ArrayList;
import java.util.List;

/**
 * Main
 */
public class Main {

    public static void main(String[] args) throws InterruptedException{
        H20Semaphore h20Semaphore = new H20Semaphore();

        List<Thread> threads = new ArrayList<Thread>();

        for(int i=0; i < 10; i++) {
            threads.add(new Thread(new Oxygen(h20Semaphore)));
        }

        for(int i=0; i < 20; i++) {
            threads.add(new Thread(new Hyrogen(h20Semaphore)));
        }

        for(int i=0; i < 30; i++) { 
            threads.get(i).start();
        }

        for(int i=0; i < 30; i++) { 
            threads.get(i).join();
        }
        System.out.println();

    }
}