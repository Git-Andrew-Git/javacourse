package fr.javacourse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChiffrementParDecalageTest {

    @Test
    void testEmptyString() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("", 3, true);
        assertEquals("", result.toString());
    }

    @Test
    void testUpperCaseForwardShift() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("ABC", 3, true);
        assertEquals("DEF", result.toString());
    }

    @Test
    void testLowerCaseForwardShift() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("abc", 3, true);
        assertEquals("def", result.toString());
    }

    @Test
    void testMixedCaseForwardShift() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("AbC", 3, true);
        assertEquals("DeF", result.toString());
    }

    @Test
    void testUpperCaseBackwardShift() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("DEF", 3, false);
        assertEquals("ABC", result.toString());
    }

    @Test
    void testLowerCaseBackwardShift() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("def", 3, false);
        assertEquals("abc", result.toString());
    }

    @Test
    void testWrapAroundZForward() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("XYZ", 3, true);
        assertEquals("ABC", result.toString());
    }

    @Test
    void testWrapAroundZBackward() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("ABC", 3, false);
        assertEquals("XYZ", result.toString());
    }

    @Test
    void testWrapAroundzForward() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("xyz", 3, true);
        assertEquals("abc", result.toString());
    }

    @Test
    void testWrapAroundzBackward() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("abc", 3, false);
        assertEquals("xyz", result.toString());
    }

    @Test
    void testLargeShiftValueForward() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("ABC", 29, true);
        assertEquals("DEF", result.toString());
    }

    @Test
    void testLargeShiftValueBackward() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("DEF", 29, false);
        assertEquals("ABC", result.toString());
    }

    @Test
    void testZeroShift() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("ABC", 0, true);
        assertEquals("ABC", result.toString());
    }

    @Test
    void testNonLetterCharacters() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("ABC123!@#", 3, true);
        assertEquals("DEF", result.toString());
    }

    @Test
    void testFullAlphabetForward() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1, true);
        assertEquals("BCDEFGHIJKLMNOPQRSTUVWXYZAB", result.toString());
    }

    @Test
    void testFullAlphabetBackward() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 1, false);
        assertEquals("ZABCDEFGHIJKLMNOPQRSTUVWXY", result.toString());
    }

    @Test
    void testShiftDirectionOverride() {
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("ABC", 3, false);
        assertEquals("DEF", result.toString()); // shift_direction is forced to true
    }
}