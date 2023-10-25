package challenge9_sorting_double_ll;

public class DoublyLL {
    private final Node head, tail;

    public DoublyLL(){
        this.head = new Node(Integer.MAX_VALUE);
        this.tail = new Node(Integer.MIN_VALUE);
        this.head.setNext(this.tail);
        this.tail.setPrev(this.head);
    }

    // No efficient as it lock all dll itself
    public synchronized void sortedInsertNaive(int num){
        Node prev = head, curr = head.getNext();

        while(curr.getNext() != null && curr.getVal() > num) {
            prev = curr;
            curr = curr.getNext();
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Node new_node = new Node(num);
        new_node.setPrev(prev);
        new_node.setNext(curr);
        prev.setNext(new_node);
        curr.setPrev(new_node);
    }


    public void sortedNaive(int num){
        Node curr = head, next = null;
        curr.getLock().lock();

        try {
            while(curr.getNext() != null) {
                next = curr.getNext();
                next.getLock().lock();

                try {
                    if (next.getVal() <= num){
                        Thread.sleep(10);
                        Node new_node = new Node(num);
                        new_node.setPrev(curr);
                        new_node.setNext(next);
                        next.setPrev(new_node);
                        curr.setNext(new_node);
                        return;
                    }
                }catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    curr.getLock().unlock();
                    curr = curr.getNext();
                }
            }
        } finally {
            next.getLock().unlock();
        }
    }

    public void traverse(){
        Node curr = head;
        while(curr != null){
            System.out.println(curr.getVal()+" ");
            curr = curr.getNext();
        }
        System.out.println();
    }

}