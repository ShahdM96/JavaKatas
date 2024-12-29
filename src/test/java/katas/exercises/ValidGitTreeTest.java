package katas.exercises;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static katas.exercises.ValidGitTree.isValidGitTree;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ValidGitTreeTest {
    @Test
    public void testIsValidGitTree() {
        Map<String, List<String>> validTree = new HashMap<>();
        validTree.put("A", List.of("B", "C"));
        validTree.put("B", List.of("D"));
        validTree.put("C", List.of());
        validTree.put("D", List.of());

        Map<String, List<String>> invalidTree = new HashMap<>();
        invalidTree.put("A", List.of("B"));
        invalidTree.put("B", List.of("C"));
        invalidTree.put("C", List.of("A")); // cycle

        assertTrue(isValidGitTree(validTree));
        assertFalse(isValidGitTree(invalidTree));
    }
}
