package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimeMeTest {
    @Test
    public void testMeasureExecutionTime(){
        Runnable test2 = () -> {int x = 1+1;};
        long output2 = TimeMe.measureExecutionTime(test2);
        assertEquals(0,output2);

    }
}
