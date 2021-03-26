package swe619;

import java.util.ArrayList;
import java.util.List;

public class BoundedQueue<T> {

    protected List<T> rep;
    protected int capacity = 0;

    //EFFECTS: instantiates a new BoundedQueue with specified capacity.
    //@throws if argument is less than or equal to 0, throws IllegalArgumentException.
    public BoundedQueue(int capacity) {
        if(capacity <= 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        rep = new ArrayList<>(capacity);
    }

    //EFFECTS: return true if size of this is equal to 0.
    public boolean isEmpty() {
        return (rep.size() == 0);
    }

    //EFFECTS: return true if size of this is equal to capacity of this.
    public boolean isFull() {
        return (rep.size() == capacity);
    }

    //EFFECTS: return number of elements in this.
    public int getCount() {
        return rep.size();
    }

    //EFFECTS: if this is not full and argument passed in is not null, add element to this.
    //@throws if argument is null, throws IllegalArgumentException.
    //@throws if this is full, throws IllegalStateException.
    public void put(T e) {
        if(e == null) throw new IllegalArgumentException();
        if(isFull()) throw new IllegalStateException();
        rep.add(e);
    }

    //EFFECTS: if this is not full and argument passed in is not null, add element to this.
    //@throws if argument is null, throws IllegalArgumentException.
    //@throws if this is full, throws IllegalStateException.
    public void putAll(Iterable<T> all, int allCapacity) {
        if((capacity-rep.size()) < allCapacity) throw new IllegalStateException();
        if(isFull()) throw new IllegalStateException();
        for (T e : all) {
            put(e);
        }
    }

    //EFFECTS: if this is not empty and element passed in is not null, add element to BoundedQueue.
    //@throws if this is empty, throws IllegalStateException.
    public T get() {
        if(isEmpty()) throw new IllegalStateException();
        T result = rep.get(0);
        for(int i=0; i<rep.size()-1; i++){
            rep.set(i, rep.get(i+1));
        }
        rep.remove(rep.size()-1);
        return result;
    }
}