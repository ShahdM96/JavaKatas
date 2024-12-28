package katas.exercises;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SemanticVersionComparatorTest {
    @Test
    public void testCompareVersions() {
        assertEquals(-1, SemanticVersionComparator.compareVersions("1.0.0", "1.0.1"));
        assertEquals(1, SemanticVersionComparator.compareVersions("2.1.0", "1.9.9"));
        assertEquals(0, SemanticVersionComparator.compareVersions("1.2.3", "1.2.3"));

    }
}
