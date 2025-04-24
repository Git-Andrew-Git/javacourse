package fr.javacourse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BintoDix_10_1Test {

    @Test
    void testValidBinaryZero() {
        assertEquals(0, BintoDix_10_1.bittoDix("0"), "Single zero should return 0");
    }

    @Test
    void testValidBinaryOne() {
        assertEquals(1, BintoDix_10_1.bittoDix("1"), "Single one should return 1");
    }

    @Test
    void testValidBinaryMultipleDigits() {
        assertEquals(5, BintoDix_10_1.bittoDix("101"), "Binary 101 should return 5");
        assertEquals(10, BintoDix_10_1.bittoDix("1010"), "Binary 1010 should return 10");
        assertEquals(255, BintoDix_10_1.bittoDix("11111111"), "Binary 11111111 should return 255");
    }

    @Test
    void testEmptyString() {
        assertEquals(0, BintoDix_10_1.bittoDix(""), "Empty string should return 0");
    }

    @Test
    void testInvalidBinaryWithLetters() {
        // Since the method catches IOException and prints "Wrong input" but still returns res (0),
        // we expect 0 for invalid inputs
        assertEquals(0, BintoDix_10_1.bittoDix("12A"), "Invalid input with letters should return 0");
        assertEquals(0, BintoDix_10_1.bittoDix("abc"), "Invalid input with only letters should return 0");
    }

    @Test
    void testInvalidBinaryWithSpecialCharacters() {
        assertEquals(0, BintoDix_10_1.bittoDix("10#"), "Invalid input with special characters should return 0");
        assertEquals(0, BintoDix_10_1.bittoDix("@"), "Invalid input with only special characters should return 0");
    }

    @Test
    void testInvalidBinaryWithNonBinaryDigits() {
        assertEquals(0, BintoDix_10_1.bittoDix("123"), "Invalid input with non-binary digits should return 0");
        assertEquals(0, BintoDix_10_1.bittoDix("987"), "Invalid input with high digits should return 0");
    }

    @Test
    void testLongBinaryString() {
        String longBinary = "1".repeat(31); // 2^31 - 1
        assertEquals(Integer.MAX_VALUE, BintoDix_10_1.bittoDix(longBinary), "Long binary string should return max int");
    }

    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> BintoDix_10_1.bittoDix(null), "Null input should throw NullPointerException");
    }

    @Test
    void testLeadingZeros() {
        assertEquals(5, BintoDix_10_1.bittoDix("00000101"), "Binary with leading zeros should return 5");
    }
}