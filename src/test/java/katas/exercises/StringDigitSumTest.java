package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringDigitSumTest {
    @Test
    public void testSumOfDigits(){
        String test1 = "I'll be there 4 you";
        String test2 = "a1 b2 c3 d4";
        String test3 = "";
        int output1 = StringDigitSum.sumOfDigits(test1);
        int output2 = StringDigitSum.sumOfDigits(test2);
        int output3 = StringDigitSum.sumOfDigits(test3);
        assertEquals(4, output1);
        assertEquals(10, output2);
        assertEquals(0, output3);


    }
}
