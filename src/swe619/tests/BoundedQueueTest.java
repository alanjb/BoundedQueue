import org.junit.Test;
import swe619.BoundedQueue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        BoundedQueue<Number> b = new BoundedQueue<>(5);
        List<Double> doubles = new ArrayList<>(3);
        doubles.add(1.0);
        doubles.add(3.2);
        doubles.add(2.1);

        b.putAll(doubles);
        assertEquals(1.0, b.get());
        assertEquals(3.2, b.get());
        assertEquals(2.1, b.get());
    }

    @Test
    public void getAll_works(){
        BoundedQueue<Number> b = new BoundedQueue<>(5);
        List<Double> integers = new ArrayList<>(3);
        integers.add(1.0);
        integers.add(2.0);
        integers.add(3.0);

        b.putAll(integers);
        assertEquals(integers, b.getAll());
    }
}