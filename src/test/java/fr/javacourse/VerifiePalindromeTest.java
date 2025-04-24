package fr.javacourse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VerifiePalindromeTest {

    @Test
    void testExclureSignesWithLettersOnly() {
        String input = "Radar";
        String expected = "Radar";
        assertEquals(expected, VerifiePalindrome.exclureSignes(input));
    }

    @Test
    void testExclureSignesWithAccents() {
        String input = "été";
        String expected = "ete";
        assertEquals(expected, VerifiePalindrome.exclureSignes(input));
    }

    @Test
    void testExclureSignesWithSpecialCharacters() {
        String input = "A,b-c!d";
        String expected = "Abcd";
        assertEquals(expected, VerifiePalindrome.exclureSignes(input));
    }

    @Test
    void testExclureSignesWithEmptyString() {
        String input = "";
        String expected = "";
        assertEquals(expected, VerifiePalindrome.exclureSignes(input));
    }

    @Test
    void testExclureSignesWithNumbersAndSpaces() {
        String input = "A1 b2 c3";
        String expected = "Abc";
        assertEquals(expected, VerifiePalindrome.exclureSignes(input));
    }

    @Test
    void testExclureSignesWithMixedAccentsAndSymbols() {
        String input = "àç-êï!ôù";
        String expected = "aceiou";
        assertEquals(expected, VerifiePalindrome.exclureSignes(input));
    }

    @Test
    void testVerifiePalindromeWithEvenLengthPalindrome() {
        String input = "deed";
        assertTrue(VerifiePalindrome.verifiePalindrome(input));
    }

    @Test
    void testVerifiePalindromeWithOddLengthPalindrome() {
        String input = "radar";
        assertTrue(VerifiePalindrome.verifiePalindrome(input));
    }

    @Test
    void testVerifiePalindromeWithNonPalindrome() {
        String input = "hello";
        assertFalse(VerifiePalindrome.verifiePalindrome(input));
    }

    @Test
    void testVerifiePalindromeWithEmptyString() {
        String input = "";
        assertFalse(VerifiePalindrome.verifiePalindrome(input));
    }

    @Test
    void testVerifiePalindromeWithSingleCharacter() {
        String input = "a";
        assertTrue(VerifiePalindrome.verifiePalindrome(input));
    }

    @Test
    void testMainWithPalindrome() {
        String input = "Radar";
        assertTrue(VerifiePalindrome.main(input));
    }

    @Test
    void testMainWithNonPalindrome() {
        String input = "Hello";
        assertFalse(VerifiePalindrome.main(input));
    }

    @Test
    void testMainWithAccentedPalindrome() {
        String input = "été";
        assertTrue(VerifiePalindrome.main(input));
    }

    @Test
    void testMainWithSpecialCharacters() {
        String input = "A,b-c!d";
        assertFalse(VerifiePalindrome.main(input));
    }

    @Test
    void testMainWithEmptyString() {
        String input = "";
        assertFalse(VerifiePalindrome.main(input));
    }
}