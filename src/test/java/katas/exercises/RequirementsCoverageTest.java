package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.List;

import static katas.exercises.RequirementsCoverage.selectMinimalTestCases;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RequirementsCoverageTest {
    @Test
    public void testSelectMinimalTestCases() {
        List<List<Integer>> testCases = List.of(
                List.of(1, 2, 3),
                List.of(1, 4),
                List.of(2, 3, 4),
                List.of(1, 5),
                List.of(3, 5)
        );

        List<Integer> result = selectMinimalTestCases(testCases);
        List<Integer> expected = List.of(2, 3);
        assertEquals(expected,result);


    }
}
