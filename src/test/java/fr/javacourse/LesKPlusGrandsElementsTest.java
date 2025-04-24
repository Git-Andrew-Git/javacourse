package fr.javacourse;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class LesKPlusGrandsElementsTest {

    @Test
    void testKGreaterThanArraySize() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertNull(LesKPlusGrandsElements.lesKPlusGrandsElements(4, input));
    }

    @Test
    void testKEqualToArraySize() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
        ArrayList<Integer> result = LesKPlusGrandsElements.lesKPlusGrandsElements(5, input);
        assertEquals(5, result.size());
        assertEquals(Arrays.asList(1, 2, 5, 8, 9), result);
    }

    @Test
    void testKLessThanArraySize() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
        ArrayList<Integer> result = LesKPlusGrandsElements.lesKPlusGrandsElements(3, input);
        assertEquals(3, result.size());
        assertEquals(Arrays.asList(1, 2, 5), result);
    }

    @Test
    void testEmptyArray() {
        ArrayList<Integer> input = new ArrayList<>();
        assertNull(LesKPlusGrandsElements.lesKPlusGrandsElements(1, input));
    }

    @Test
    void testKEqualToZero() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> result = LesKPlusGrandsElements.lesKPlusGrandsElements(0, input);
        assertEquals(0, result.size());
    }

    @Test
    void testSingleElementArray() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> result = LesKPlusGrandsElements.lesKPlusGrandsElements(1, input);
        assertEquals(1, result.size());
        assertEquals(Arrays.asList(1), result);
    }

    @Test
    void testDuplicateElements() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 3, 3, 2, 2));
        ArrayList<Integer> result = LesKPlusGrandsElements.lesKPlusGrandsElements(3, input);
        assertEquals(3, result.size());
        assertEquals(Arrays.asList(2, 2, 3), result);
    }

    @Test
    void testNegativeElements() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(-5, -2, -8, -1, -9));
        ArrayList<Integer> result = LesKPlusGrandsElements.lesKPlusGrandsElements(3, input);
        assertEquals(3, result.size());
        assertEquals(Arrays.asList(-8, -5, -2), result);
    }

    @Test
    void testQuickSortEmptyArray() {
        ArrayList<Integer> input = new ArrayList<>();
        LesKPlusGrandsElements.quickSort(input, 0, input.size() - 1);
        assertTrue(input.isEmpty());
    }

    @Test
    void testQuickSortSingleElement() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1));
        LesKPlusGrandsElements.quickSort(input, 0, input.size() - 1);
        assertEquals(Arrays.asList(1), input);
    }

    @Test
    void testQuickSortSortedArray() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        LesKPlusGrandsElements.quickSort(input, 0, input.size() - 1);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), input);
    }

    @Test
    void testQuickSortReverseSortedArray() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(5, 4, 3, 2, 1));
        LesKPlusGrandsElements.quickSort(input, 0, input.size() - 1);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), input);
    }

    @Test
    void testQuickSortDuplicateElements() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 3, 3, 2, 2));
        LesKPlusGrandsElements.quickSort(input, 0, input.size() - 1);
        assertEquals(Arrays.asList(2, 2, 3, 3, 3), input);
    }
}