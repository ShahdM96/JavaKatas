package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrueCounterTest {
    @Test
    public void testCountTrueValues(){
        boolean[] test1 = {true, false, true, false, false};
        boolean[] test2 = {false};
        boolean[] test3 = {true};
        boolean[] test4 = {};

        int output1 = TrueCounter.countTrueValues(test1);
        int output2 = TrueCounter.countTrueValues(test2);
        int output3 = TrueCounter.countTrueValues(test3);
        int output4 = TrueCounter.countTrueValues(test4);

        assertEquals(2, output1);
        assertEquals(0, output2);
        assertEquals(1, output3);
        assertEquals(0, output4);
    }
}
