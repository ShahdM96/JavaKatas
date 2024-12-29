package katas.exercises;

import org.junit.jupiter.api.Test;

import static katas.exercises.MaxStorageCapacity.maxStorageArea;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxStorageCapacityTest {
    @Test
    public void testMaxStorageArea(){
        int[] containers = {2, 1, 5, 6, 2, 3};

        int result = maxStorageArea(containers);
        assertEquals(10, result,"incorrrect output");


    }
}
