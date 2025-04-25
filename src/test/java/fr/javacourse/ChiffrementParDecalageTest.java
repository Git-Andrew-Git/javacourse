package fr.javacourse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @Test
    void testEmptyString2() {
        // Covers loop skip (line 21) and return (line 64)
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("", 3, true);
        assertEquals("", result.toString());
    }

    @Test
    void testNonLetterInput() {
        // Covers else branch of if (Character.isLetter(...)) (line 22)
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("123 !@#", 5, true);
        assertEquals("", result.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "ABC, 3, true, DEF",   // Uppercase, positive shift, covers lines 23, 29, 31–34
            "xyz, 3, true, abc",   // Lowercase, positive shift, covers lines 25, 46–48
            "ABC, 1, false, ABC",  // Shift direction false, covers line 30
            "XYZ, -3, false, ABC", // Negative shift, uppercase underflow, covers lines 42–45
            "abc, -3, false, xyz"  // Negative shift, lowercase underflow, covers lines 57–59
    })
    void testShiftCases(String input, int shift, boolean direction, String expected) {
        // Covers shift_direction branches (line 28), grandoupetit (lines 23, 25), and wrap-around logic
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage(input, shift, direction);
        assertEquals(expected, result.toString());
    }

    @ParameterizedTest
    @CsvSource({
            "ABC, 27, true, ABC",  // Large shift, uppercase, covers lines 35, 38
            "abc, 27, true, abc",  // Large shift, lowercase, covers lines 51–56
            "XYZ, -27, false, XYZ",// Large negative shift, uppercase, covers lines 41–45
            "xyz, -27, false, xyz" // Large negative shift, lowercase, covers lines 50, 57–59
    })
    void testEdgeCaseShifts(String input, int shift, boolean direction, String expected) {
        // Covers edge cases for large/negative shifts and modulo logic
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage(input, shift, direction);
        assertEquals(expected, result.toString());
    }

    @Test
    void testMixedCase() {
        // Covers both uppercase and lowercase branches (lines 23, 25)
        StringBuilder result = ChiffrementParDecalage.chiffrementParDecalage("AbC", 2, true);
        assertEquals("CdE", result.toString());
    }
}