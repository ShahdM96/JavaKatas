package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderedMapTest {
    @Test
    public void testsize() {
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        assertEquals(2,orderedMap.size(),"Incorrect size");

        orderedMap.put("Three", 3);
        assertEquals(3,orderedMap.size(),"Incorrect size");
        orderedMap.clear();
        assertEquals(0,orderedMap.size(),"Incorrect size");
    }
    @Test
    public void testGet() {
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);
        assertEquals(2, orderedMap.get("Two"), "Incorrect element expected 2");
        assertEquals(3, orderedMap.get("Three"), "Incorrect element expected 3");
        assertEquals(1, orderedMap.get("One"), "Incorrect element expected 1");

    }
    @Test
    public void testOrder() {
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);
        List<String> test1 = new ArrayList<>();
        test1.add("One");
        test1.add("Two");
        test1.add("Three");
        assertEquals(test1, orderedMap.keys(), "Incorrect order");

        orderedMap.remove("Two");
        List<String> test2 = new ArrayList<>();
        test2.add("One");
        test2.add("Three");
        assertEquals(test2, orderedMap.keys(), "Incorrect order");
        orderedMap.put("Two", 22);
        List<String> test3 = new ArrayList<>();
        test3.add("One");
        test3.add("Three");
        test3.add("Two");
        assertEquals(test3, orderedMap.keys(), "Incorrect order");
    }

    @Test
    void tesDuplicateKeys() {
        OrderedMap<String, Integer> orderedMap = new OrderedMap<>();

        orderedMap.put("Two", 2);
        orderedMap.put("Two", 22);

        assertEquals(22, orderedMap.get("Two"), "Incorrect value - expected 22");
        assertEquals(1, orderedMap.size(), "Incorrect size - expected 1");
    }
    }
