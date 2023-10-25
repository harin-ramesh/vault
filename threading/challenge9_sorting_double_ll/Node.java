package challenge9_sorting_double_ll;

import java.util.concurrent.locks.ReentrantLock;

public class Node {
    private int val;
    private Node prev, next;
    private final ReentrantLock lock;

    public Node(int val){
        this.val = val;
        this.lock = new ReentrantLock();
    }

    public int getVal(){
        return this.val;
    }    

    public Node getNext(){
        return this.next;
    }

    public Node getPrev(){
        return this.prev;
    }

    public ReentrantLock getLock(){
        return this.lock;
    }

    public void setVal(int val){
        this.val = val;
    }

    public void setNext(Node next){
        // System.out.println("Set next called " + next.getVal());
        this.next = next;
    }

    public void setPrev(Node prev){
        // System.out.println("Set prev called " + prev.getVal());
        this.prev = prev;
    }
}