package challenge11_read_write_lock;

public class Writer implements Runnable{
    Store store;

    public Writer(Store store){
        this.store = store;
    }

    @Override
    public void run() {
        try {
            store.write();
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("Writer writing something");
    }
}
