package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SlidingWindowMaximumTest {
    @Test
    public void testMaxSlidingWindow(){
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(3);
        expected.add(5);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        List<Integer> result =SlidingWindowMaximum.maxSlidingWindow(nums, k);
        assertArrayEquals(expected.toArray(), result.toArray(),"incorrect output");
    }
}
