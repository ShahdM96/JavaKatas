package katas.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

public class MinStackTest {

    private MinStack stack;

    @BeforeEach
    public void setUp() {
        stack = new MinStack();
    }

    @Test
    public void testPushAndGetMin() {
        stack.push(-2);
        stack.push(0);
        stack.push(-3);

        assertEquals(-3, stack.getMin(), "The minimum value should be -3");

        stack.pop();
        assertEquals(-2, stack.getMin(), "The minimum value should be -2 after popping -3");

        stack.push(-4);
        assertEquals(-4, stack.getMin(), "The minimum value should be -4 after pushing -4");
    }

    @Test
    public void testPopAndTop() {
        stack.push(-2);
        stack.push(0);
        stack.push(-3);

        assertEquals(-3, stack.top(), "The top value should be -3 before popping");

        stack.pop();
        assertEquals(0, stack.top(), "The top value should be 0 after popping -3");

        stack.pop();
        assertEquals(-2, stack.top(), "The top value should be -2 after popping 0");
    }

    @Test
    public void testEmptyStack() {
        stack.push(10);
        stack.pop();
        assertThrows(EmptyStackException.class, () -> stack.pop(), "Popping from an empty stack should throw an exception");
        assertThrows(EmptyStackException.class, () -> stack.top(), "Getting top from an empty stack should throw an exception");
        assertThrows(EmptyStackException.class, () -> stack.getMin(), "Getting min from an empty stack should throw an exception");
    }
}
