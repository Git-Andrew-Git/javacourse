package fr.javacourse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MiroirCC_9_4Test {

    @Test
    void testInvertCharsWithNormalString() {
        String input = "hello";
        String expected = "olleh";
        assertEquals(expected, MiroirCC_9_4.invertChars(input));
    }

    @Test
    void testInvertCharsWithEmptyString() {
        String input = "";
        String expected = "";
        assertEquals(expected, MiroirCC_9_4.invertChars(input));
    }

    @Test
    void testInvertCharsWithSingleCharacter() {
        String input = "a";
        String expected = "a";
        assertEquals(expected, MiroirCC_9_4.invertChars(input));
    }

    @Test
    void testInvertCharsWithSpaces() {
        String input = "hello world";
        String expected = "dlrow olleh";
        assertEquals(expected, MiroirCC_9_4.invertChars(input));
    }

    @Test
    void testInvertCharsWithSpecialCharacters() {
        String input = "hello!@#";
        String expected = "#@!olleh";
        assertEquals(expected, MiroirCC_9_4.invertChars(input));
    }

    @Test
    void testInvertCharsWithNumbers() {
        String input = "12345";
        String expected = "54321";
        assertEquals(expected, MiroirCC_9_4.invertChars(input));
    }

    @Test
    void testInvertCharsWithMixedCase() {
        String input = "HeLLo";
        String expected = "oLLeH";
        assertEquals(expected, MiroirCC_9_4.invertChars(input));
    }

    @Test
    void testInvertCharsWithNull() {
        assertThrows(NullPointerException.class, () -> MiroirCC_9_4.invertChars(null));
    }

    @Test
    void testInvertCharsWithUnicode() {
        String input = "héllo😊";
        String expected = "😊olleh";
        assertEquals(expected, MiroirCC_9_4.invertChars(input));
    }

    @Test
    void testInvertCharsWithLongString() {
        String input = "a".repeat(1000);
        String expected = "a".repeat(1000);
        assertEquals(expected, MiroirCC_9_4.invertChars(input));
    }
}