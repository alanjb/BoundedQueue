package swe619;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//Client invariant: BoundedQueue objects can never of size less than 0.
public class BoundedQueue<T> {
    protected List<T> rep;
    protected int capacity;

    //Rep Invariant:    rep is not null.
    //                  capacity is not less than 0.

    //POST: @throw IllegalArgumentException if capacity is less than 0.
    //POST: creates a BoundedQueue with a bounded (finite size) capacity.
    public BoundedQueue(int capacity) {
        if(capacity < 0) throw new IllegalArgumentException();
        this.capacity = capacity;
        rep = new ArrayList<>(capacity); //rep is never null
    }

    //POST: @return true if size of this is equal to 0.
    public boolean isEmpty() {
        return (rep.size() == 0);
    }

    //POST: @return true if size of this is equal to capacity of this.
    public boolean isFull() {
        return (rep.size() == capacity);
    }

    //POST: @return number of elements in this.
    public int getCount() {
        return rep.size();
    }

    //POST: @throw NPE if element is null.
    //POST: @throw ISE if this is full.
    //POST: @throw ISE if capacity of this is 0.
    //POST: add element to this.
    public void put(T element) {
        if(element == null) throw new NullPointerException();
        if(isFull()) throw new IllegalStateException();
        rep.add(element);
    }

    //POST: @throw IllegalStateException if the available space in this is less than the capacity of all.
    //POST: @throw IllegalStateException if this is full.
    //POST: add all to this.
    public void putAll(Collection<? extends T> all) {
        if(((capacity-rep.size()) < all.size()) || isFull()) throw new IllegalStateException();
        for (T element : all) {
            put(element);
        }
    }

    //POST: @throw IllegalStateException if this is empty.
    //POST: @return the head of this.
    public T get() {
        if(isEmpty()) throw new IllegalStateException();
        T result = rep.get(0);
        for(int i=0; i<rep.size()-1; i++){
            rep.set(i, rep.get(i+1));
        }
        rep.remove(rep.size()-1);
        return result;
    }

    //POST: @throw IllegalStateException if this is empty.
    //POST: @return all elements of this.
    public List<T> getAll(){
        List<T> dst = new ArrayList<>(capacity);
        while (!isEmpty()){
            dst.add(get());
        }
        return dst;
    }
}