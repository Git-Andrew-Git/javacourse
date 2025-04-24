package fr.javacourse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LocalisationSousChCar_9_6Test {

    @Test
    void testEmptyText() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("", "abc");
        assertArrayEquals(new int[]{-1, -1}, result, "Empty text should return [-1, -1]");
    }

    @Test
    void testEmptySearch() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("abc", "");
        assertArrayEquals(new int[]{-1, -1}, result, "Empty search string should return [-1, -1]");
    }

    @Test
    void testBothEmpty() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("", "");
        assertArrayEquals(new int[]{-1, -1}, result, "Both empty strings should return [-1, -1]");
    }

    @Test
    void testSearchLongerThanText() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("abc", "abcd");
        assertArrayEquals(new int[]{-1, -1}, result, "Search longer than text should return [-1, -1]");
    }

    @Test
    void testSingleCharMatch() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("abc", "b");
        assertArrayEquals(new int[]{1, 1}, result, "Single character match should return correct indices");
    }

    @Test
    void testSingleCharNoMatch() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("abc", "d");
        assertArrayEquals(new int[]{-1, -1}, result, "Single character not found should return [-1, -1]");
    }

    @Test
    void testMultipleCharMatchAtStart() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("abcdef", "abc");
        assertArrayEquals(new int[]{0, 2}, result, "Match at start should return correct indices");
    }

    @Test
    void testMultipleCharMatchAtEnd() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("abcdef", "def");
        assertArrayEquals(new int[]{3, 5}, result, "Match at end should return correct indices");
    }

    @Test
    void testMultipleCharMatchInMiddle() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("abcdef", "bcd");
        assertArrayEquals(new int[]{1, 3}, result, "Match in middle should return correct indices");
    }

    @Test
    void testNoMatch() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("abcdef", "xyz");
        assertArrayEquals(new int[]{-1, -1}, result, "No match should return [-1, -1]");
    }

    @Test
    void testCaseSensitiveMatch() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("Abcdef", "abc");
        assertArrayEquals(new int[]{-1, -1}, result, "Case-sensitive no match should return [-1, -1]");
    }

    @Test
    void testMultipleOccurrencesFirstMatch() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("ababc", "abc");
        assertArrayEquals(new int[]{2, 4}, result, "Should return first match indices");
    }

    @Test
    void testTextEqualsSearch() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("abc", "abc");
        assertArrayEquals(new int[]{0, 2}, result, "Text equals search should return full indices");
    }

    @Test
    void testSingleCharTextAndSearch() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("a", "a");
        assertArrayEquals(new int[]{0, 0}, result, "Single char text and search should return [0, 0]");
    }

    @Test
    void testNullText() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC(null, "abc");
        assertArrayEquals(new int[]{-1, -1}, result, "Null text should return [-1, -1]");
    }

    @Test
    void testNullSearch() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("abc", null);
        assertArrayEquals(new int[]{-1, -1}, result, "Null search should return [-1, -1]");
    }

    @Test
    void testSpecialCharacters() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("hello@world", "@wo");
        assertArrayEquals(new int[]{5, 7}, result, "Special characters match should return correct indices");
    }

    @Test
    void testSpacesInTextAndSearch() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("hello world", "lo w");
        assertArrayEquals(new int[]{3, 6}, result, "Spaces in text and search should return correct indices");
    }

    @Test
    void testPartialMatchNotReturned() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("abcd", "bcdz");
        assertArrayEquals(new int[]{-1, -1}, result, "Partial match should not return indices");
    }

    @Test
    void testUnicodeCharacters() {
        int[] result = LocalisationSousChCar_9_6.localisationSCC("héllo世界", "世界");
        assertArrayEquals(new int[]{5, 6}, result, "Unicode characters match should return correct indices");
    }
}