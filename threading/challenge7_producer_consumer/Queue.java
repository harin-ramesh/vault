package challenge7_producer_consumer;

import java.util.ArrayList;
import java.util.List;


public class Queue {
    private int front, rear;
    private final int capacity;
    private final List<Integer> list;

    public Queue(int capacity){
        this.capacity = capacity;
        this.list = new ArrayList<>();
        this.front = -1;
        this.rear = 0;
    }

    public boolean isFull() {return (front - rear + 1 == capacity);}

    public boolean isEmpty() {return (rear > front);}

    public void push(Integer x){
        if(isFull()){
            throw new RuntimeException("Queue overflow");
        }
        list.add(x);
        front++;
    }

    public Integer pop(){
        if(isEmpty()){
            throw new RuntimeException("Queue underflow");
        }
        Integer val = list.get(rear++);
        return val;
    }
}
