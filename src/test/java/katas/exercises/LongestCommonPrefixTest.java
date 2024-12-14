package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LongestCommonPrefixTest {
    @Test
    public void testLongestCommonPrefix(){
        String[] test1 = {"a", "ab", "abc", "abcd"};
        String[] test2 = {"her", "help", "head"};
        String[] test3 = {"green", "red", "black"};
        String expected1 = "a";
        String expected2 = "he";
        String output1 = LongestCommonPrefix.longestCommonPrefix(test1);
        String output2 = LongestCommonPrefix.longestCommonPrefix(test2);
        String output3 = LongestCommonPrefix.longestCommonPrefix(test3);

        assertEquals(expected1, output1);
        assertEquals(expected2,output2);
        assertEquals("",output3);




    }
}
