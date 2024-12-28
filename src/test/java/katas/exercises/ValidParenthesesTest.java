package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidParenthesesTest {
    @Test
    public void testIsValidParentheses() {
        String validInput = "()[]{}";
        String invalidInput1 = "(]";
        String invalidInput2 = "([)]";
        String validInputNested = "{[()]}";

        assertFalse(ValidParentheses.isValidParentheses(invalidInput1));
        assertFalse(ValidParentheses.isValidParentheses(invalidInput2));
        assertTrue(ValidParentheses.isValidParentheses(validInput));
        assertTrue(ValidParentheses.isValidParentheses(validInputNested));


    }
}
