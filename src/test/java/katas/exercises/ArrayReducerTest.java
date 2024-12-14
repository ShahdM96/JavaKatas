package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ArrayReducerTest {
    @Test
    public void testReduceArray() {
        int[] input = {1,2,3,4,5,6};
        int[] expected = {1,1,1,1,1,1};
        ArrayReducer.reduceArray(input);
        assertArrayEquals(expected, input, "incorrect result");
    }

}
