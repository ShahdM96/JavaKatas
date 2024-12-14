package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UniqueStringTest {
    @Test
    public void testIsUnique(){
        String test1 = "shahd";
        String test2 = "abcde";
        String test3 = "Abab";
        assertFalse(UniqueString.isUnique(test1));
        assertTrue(UniqueString.isUnique(test2));
        assertFalse(UniqueString.isUnique(test3));
        assertTrue(UniqueString.isUnique(""));


    }
}
