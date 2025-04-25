package fr.javacourse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class BinomesStagiairesTest {

    private String[] learnerNames;

    @BeforeEach
    void setUp() {
        learnerNames = new String[]{"Alice", "Bob", "Charlie", "David"};
    }

    @Test
    void testEmptyArray() {
        String[] emptyNames = new String[]{};
        ArrayList<Integer> result = BinomesStagiaires.binomesStagiaires(emptyNames);
        assertTrue(result.isEmpty(), "Empty input array should return empty list");
    }

    @Test
    void testSingleElementArray() {
        String[] singleName = new String[]{"Alice"};
        ArrayList<Integer> result = BinomesStagiaires.binomesStagiaires(singleName);
        assertEquals(1, result.size(), "Single element array should return list with one element");
        assertTrue(result.get(0) >= 1 && result.get(0) <= 1, "Single element should map to group 1");
    }

    @Test
    void testEvenNumberOfLearners() {
        ArrayList<Integer> result = BinomesStagiaires.binomesStagiaires(learnerNames);
        assertEquals(learnerNames.length, result.size(), "Result size should match input size");
        for (Integer group : result) {
            assertTrue(group >= 1 && group <= learnerNames.length / 2,
                    "Group numbers should be between 1 and " + learnerNames.length / 2);
        }
    }

    @Test
    void testOddNumberOfLearners() {
        String[] oddNames = new String[]{"Alice", "Bob", "Charlie", "David", "Eve"};
        ArrayList<Integer> result = BinomesStagiaires.binomesStagiaires(oddNames);
        assertEquals(oddNames.length, result.size(), "Result size should match input size");
        for (Integer group : result) {
            assertTrue(group >= 1 && group <= (oddNames.length / 2) + 1,
                    "Group numbers should be between 1 and " + ((oddNames.length / 2) + 1));
        }
    }

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> {
            BinomesStagiaires.binomesStagiaires(null);
        }, "Null input should throw NullPointerException");
    }

    @Test
    void testLargeInput() {
        String[] largeNames = new String[100];
        for (int i = 0; i < largeNames.length; i++) {
            largeNames[i] = "Learner" + i;
        }
        ArrayList<Integer> result = BinomesStagiaires.binomesStagiaires(largeNames);
        assertEquals(largeNames.length, result.size(), "Result size should match large input size");
        for (Integer group : result) {
            assertTrue(group >= 1 && group <= largeNames.length / 2,
                    "Group numbers should be between 1 and " + largeNames.length / 2);
        }
    }

    @Test
    void testConsistencyWithSameInput() {
        ArrayList<Integer> result1 = BinomesStagiaires.binomesStagiaires(learnerNames);
        ArrayList<Integer> result2 = BinomesStagiaires.binomesStagiaires(learnerNames);
        assertEquals(result1.size(), result2.size(), "Results should have same size for same input");
        // Note: Due to randomness, actual values may differ
    }
}