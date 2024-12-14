package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ListFlattenTest {
    @Test
    public void testFlattenList() {
        List<Object> input = new ArrayList<>();
        input.add(1);
        input.add(List.of(2, 3));
        input.add(List.of(4, List.of(5, 6)));
        input.add(7);
        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);
        expected.add(6);
        expected.add(7);
        List<Integer> output = ListFlatten.flattenList(input);
        assertArrayEquals(expected.toArray(), output.toArray(),"incorrect output");

    }
}
