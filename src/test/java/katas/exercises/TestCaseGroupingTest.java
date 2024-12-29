package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestCaseGroupingTest {
    @Test
    public void testGroupTestCases() {
        List<Integer> test1 = List.of(1, 2, 3, 3, 3, 2);
        List<List<Integer>> testCaseGroups1 = TestCaseGrouping.groupTestCases(test1);
        List<List<Integer>> expected =  List.of( List.of(0),  List.of(2, 3, 4),  List.of(1, 5));
        assertArrayEquals(expected.toArray(), testCaseGroups1.toArray(),"incorrect output");

    }
}
