package fr.javacourse;

import fr.javacourse.FusionnerDeuxTableauTrie;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FusionnerDeuxTableauTrieTest {

    @Test
    void testEmptyArrays() {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> result = FusionnerDeuxTableauTrie.fusionnerDeuxTableauTrie(arr1, arr2);
        assertEquals(new ArrayList<>(), result);
    }

    @Test
    void testOneEmptyArray() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> arr2 = new ArrayList<>();
        ArrayList<Integer> result = FusionnerDeuxTableauTrie.fusionnerDeuxTableauTrie(arr1, arr2);
        assertEquals(new ArrayList<>(Arrays.asList(1, 2)), result);
    }

    @Test
    void testSingleElementArrays() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2));
        ArrayList<Integer> result = FusionnerDeuxTableauTrie.fusionnerDeuxTableauTrie(arr1, arr2);
        assertEquals(new ArrayList<>(Arrays.asList(1, 2)), result);
    }

    @Test
    void testEqualSizedArrays() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 3, 5));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2, 4, 6));
        ArrayList<Integer> result = FusionnerDeuxTableauTrie.fusionnerDeuxTableauTrie(arr1, arr2);
        assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), result);
    }

    @Test
    void testDifferentSizedArrays() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(3, 4, 5, 6));
        ArrayList<Integer> result = FusionnerDeuxTableauTrie.fusionnerDeuxTableauTrie(arr1, arr2);
        assertEquals(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)), result);
    }

    @Test
    void testDuplicateElements() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 2, 2));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(2, 3, 3));
        ArrayList<Integer> result = FusionnerDeuxTableauTrie.fusionnerDeuxTableauTrie(arr1, arr2);
        assertEquals(new ArrayList<>(Arrays.asList(1, 2, 2, 2, 3, 3)), result);
    }

    @Test
    void testNegativeNumbers() {
        ArrayList<Integer> arr1 = new ArrayList<>(Arrays.asList(-2, -1, 0));
        ArrayList<Integer> arr2 = new ArrayList<>(Arrays.asList(-3, -1, 1));
        ArrayList<Integer> result = FusionnerDeuxTableauTrie.fusionnerDeuxTableauTrie(arr1, arr2);
        assertEquals(new ArrayList<>(Arrays.asList(-3, -2, -1, -1, 0, 1)), result);
    }
}