package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordCounterTest {
    @Test
    public void testCountWords(){
        String test1 ="          Hello world            ";
        String test2 ="    a b c d    ";
        String test3 ="";
        int output1 = WordCounter.countWords(test1);
        int output2 =  WordCounter.countWords(test2);
        int output3 =  WordCounter.countWords(test3);
        assertEquals(2, output1);
        assertEquals(4, output2);
        assertEquals(0, output3);


    }
}
