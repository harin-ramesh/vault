package challenge11_read_write_lock;

public class Reader implements Runnable{
    Store store;

    public Reader(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        String name = null;
        try {
            name = store.read();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("Reader reads, Name: " + name);
    }
}
