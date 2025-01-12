package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CircularBufferTest {

    @Test
    public void testCircularBuffer() {
        CircularBuffer buffer = new CircularBuffer(3);

        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        assertEquals(1, buffer.get());
        buffer.add(4);
        assertEquals(2, buffer.get());
        buffer.add(5);
        assertTrue(buffer.isFull());
    }
}
