package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayDifferenceTest {

    @Test
    public void testFindDifference() {
        int[] arr = {1,5,2,7,-1};
        int expected = 8;
        int result = ArrayDifference.findDifference(arr);
        int[] arr1 = {};
        assertEquals(expected, result, "incorrect result");
        assertEquals(0, ArrayDifference.findDifference(arr1), "empty array");
    }
}
