package fr.javacourse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DecomptMaj_9_2Test {

    // Tests for checkMaj method
    @Test
    void testCheckMajUpperCaseLetter() {
        assertEquals(1, DecomptMaj_9_2.checkMaj('A'), "Uppercase letter should return 1");
        assertEquals(1, DecomptMaj_9_2.checkMaj('Z'), "Uppercase letter should return 1");
    }

    @Test
    void testCheckMajLowerCaseLetter() {
        assertEquals(0, DecomptMaj_9_2.checkMaj('a'), "Lowercase letter should return 0");
        assertEquals(0, DecomptMaj_9_2.checkMaj('z'), "Lowercase letter should return 0");
    }

    @Test
    void testCheckMajNonLetter() {
        assertEquals(0, DecomptMaj_9_2.checkMaj('1'), "Non-letter should return 0");
        assertEquals(0, DecomptMaj_9_2.checkMaj('?'), "Non-letter should return 0");
        assertEquals(0, DecomptMaj_9_2.checkMaj(' '), "Space should return 0");
    }

    // Tests for recursionMaj method
    @Test
    void testRecursionMajEmptyString() {
        assertEquals(0, DecomptMaj_9_2.recursionMaj("", 0), "Empty string should return 0");
    }

    @Test
    void testRecursionMajSingleUpperCase() {
        assertEquals(1, DecomptMaj_9_2.recursionMaj("A", 1), "Single uppercase should return 1");
    }

    @Test
    void testRecursionMajSingleLowerCase() {
        assertEquals(0, DecomptMaj_9_2.recursionMaj("a", 1), "Single lowercase should return 0");
    }

    @Test
    void testRecursionMajMixedString() {
        assertEquals(3, DecomptMaj_9_2.recursionMaj("HeLLo", 5), "HeLLo should return 3");
        assertEquals(2, DecomptMaj_9_2.recursionMaj("AbCd", 4), "AbCd should return 2");
    }

    @Test
    void testRecursionMajNoUpperCase() {
        assertEquals(0, DecomptMaj_9_2.recursionMaj("hello", 5), "No uppercase should return 0");
        assertEquals(0, DecomptMaj_9_2.recursionMaj("abc123", 6), "No uppercase should return 0");
    }

    @Test
    void testRecursionMajAllUpperCase() {
        assertEquals(5, DecomptMaj_9_2.recursionMaj("HELLO", 5), "All uppercase should return 5");
        assertEquals(3, DecomptMaj_9_2.recursionMaj("ABC", 3), "All uppercase should return 3");
    }

    @Test
    void testRecursionMajWithSpecialCharacters() {
        assertEquals(2, DecomptMaj_9_2.recursionMaj("A!B@c", 5), "String with special chars should count only uppercase");
        assertEquals(1, DecomptMaj_9_2.recursionMaj("X?!", 3), "String with special chars should count only uppercase");
    }

    @Test
    void testRecursionMajWithSpaces() {
        assertEquals(2, DecomptMaj_9_2.recursionMaj("A B C", 5), "String with spaces should count only uppercase");
        assertEquals(1, DecomptMaj_9_2.recursionMaj("Hello World", 11), "String with spaces should count only uppercase");
    }
}