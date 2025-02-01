package katas.exercises;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MedianFinderTest {

    private MedianFinder medianFinder;

    @BeforeEach
    void setUp() {
        medianFinder = new MedianFinder();
    }

    @Test
    void test1() {
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);

        assertEquals(2.0, medianFinder.findMedian());
    }

    @Test
    void test2() {
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        medianFinder.addNum(4);

        assertEquals(2.5, medianFinder.findMedian());
    }

    @Test
    void test3() {
        medianFinder.addNum(10);

        assertEquals(10.0, medianFinder.findMedian());
    }

    @Test
    void test5() {
        for (int i = 1; i <= 1000; i++) {
            medianFinder.addNum(i);
        }

        assertEquals(500.5, medianFinder.findMedian());
    }
}
