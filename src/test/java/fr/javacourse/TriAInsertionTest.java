package fr.javacourse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriAInsertionTest {

    @Test
    void testInsertionSortEmptyArray() {
        int[] input = {};
        Object[] result = TriAInsertion.insertionSort(input);
        int[] sortedArray = (int[]) result[0];
        int counter = (int) result[1];
        assertArrayEquals(new int[]{}, sortedArray);
        assertEquals(0, counter);
    }

    @Test
    void testInsertionSortSingleElement() {
        int[] input = {1};
        Object[] result = TriAInsertion.insertionSort(input);
        int[] sortedArray = (int[]) result[0];
        int counter = (int) result[1];
        assertArrayEquals(new int[]{1}, sortedArray);
        assertEquals(0, counter);
    }

    @Test
    void testInsertionSortSortedArray() {
        int[] input = {1, 2, 3, 4, 5};
        Object[] result = TriAInsertion.insertionSort(input);
        int[] sortedArray = (int[]) result[0];
        int counter = (int) result[1];
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortedArray);
        assertEquals(4, counter);
    }

    @Test
    void testInsertionSortReverseSortedArray() {
        int[] input = {5, 4, 3, 2, 1};
        Object[] result = TriAInsertion.insertionSort(input);
        int[] sortedArray = (int[]) result[0];
        int counter = (int) result[1];
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortedArray);
        assertEquals(4, counter);
    }

    @Test
    void testInsertionSortUnsortedArray() {
        int[] input = {3, 1, 4, 2, 5};
        Object[] result = TriAInsertion.insertionSort(input);
        int[] sortedArray = (int[]) result[0];
        int counter = (int) result[1];
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sortedArray);
        assertEquals(4, counter);
    }

    @Test
    void testInsertionSortDuplicateElements() {
        int[] input = {2, 2, 1, 3, 2};
        Object[] result = TriAInsertion.insertionSort(input);
        int[] sortedArray = (int[]) result[0];
        int counter = (int) result[1];
        assertArrayEquals(new int[]{1, 2, 2, 2, 3}, sortedArray);
        assertEquals(4, counter);
    }

    @Test
    void testInsertionSortNegativeNumbers() {
        int[] input = {-3, 1, -1, 2, -2};
        Object[] result = TriAInsertion.insertionSort(input);
        int[] sortedArray = (int[]) result[0];
        int counter = (int) result[1];
        assertArrayEquals(new int[]{-3, -2, -1, 1, 2}, sortedArray);
        assertEquals(4, counter);
    }

    @Test
    void testInsertionSortAllSameElements() {
        int[] input = {1, 1, 1, 1};
        Object[] result = TriAInsertion.insertionSort(input);
        int[] sortedArray = (int[]) result[0];
        int counter = (int) result[1];
        assertArrayEquals(new int[]{1, 1, 1, 1}, sortedArray);
        assertEquals(3, counter);
    }

    @Test
    void testInsertionSortLargeArray() {
        int[] input = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        Object[] result = TriAInsertion.insertionSort(input);
        int[] sortedArray = (int[]) result[0];
        int counter = (int) result[1];
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, sortedArray);
        assertEquals(9, counter);
    }

    @Test
    void testInsertionSortNullInput() {
        int[] input = null;
        assertThrows(NullPointerException.class, () -> TriAInsertion.insertionSort(input));
    }
}