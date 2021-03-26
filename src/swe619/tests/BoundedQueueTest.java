import org.junit.Test;
import swe619.BoundedQueue;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BoundedQueueTest {

    @Test
    public void isEmpty_works(){
        BoundedQueue<Integer> b = new BoundedQueue<>(5);
        assertTrue(b.isEmpty());
    }

    @Test
    public void isFull_works(){
        BoundedQueue<Integer> b = new BoundedQueue<>(5);
        b.put(0);
        b.put(1);
        b.put(2);
        b.put(3);
        b.put(4);
        assertTrue(b.isFull());
    }

    @Test
    public void getCount_works(){
        BoundedQueue<Integer> b = new BoundedQueue<>(5);
        b.put(0);
        b.put(1);
        b.put(2);
        b.put(3);
        assertEquals(4,b.getCount());
    }

    @Test
    public void put_get_work(){
        BoundedQueue<Integer> b = new BoundedQueue<>(5);
        b.put(0);
        assertEquals(0, (int) b.get());
    }

    @Test
    public void putAll_works(){
        BoundedQueue<Integer> b = new BoundedQueue<>(5);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        b.putAll(list, list.size());
        assertEquals(1, (int) b.get());
        assertEquals(2, (int) b.get());
        assertEquals(3, (int) b.get());
        assertEquals(4, (int) b.get());
    }
}