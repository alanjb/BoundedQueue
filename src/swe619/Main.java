package swe619;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BoundedQueue<Integer> b = new BoundedQueue<>(5);
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(10);
        b.putAll(list, list.size());
        System.out.println(b.isFull());
    }
}
