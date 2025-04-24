package fr.javacourse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DecimalToBinaireTest {

    @Test
    void testZeroInput() {
        assertEquals("0000", DecimalToBinaire.deciamlToBinaire(0));
    }

    @Test
    void testPositiveNumberOne() {
        assertEquals("1", DecimalToBinaire.deciamlToBinaire(1));
    }

    @Test
    void testPositiveNumberTwo() {
        assertEquals("10", DecimalToBinaire.deciamlToBinaire(2));
    }

    @Test
    void testPositiveNumberThree() {
        assertEquals("11", DecimalToBinaire.deciamlToBinaire(3));
    }

    @Test
    void testPositiveNumberTen() {
        assertEquals("1010", DecimalToBinaire.deciamlToBinaire(10));
    }

    @Test
    void testPositiveNumberFifteen() {
        assertEquals("1111", DecimalToBinaire.deciamlToBinaire(15));
    }

    @Test
    void testLargePositiveNumber() {
        assertEquals("100000000", DecimalToBinaire.deciamlToBinaire(256));
    }

    @Test
    void testNegativeNumber() {
        assertEquals("", DecimalToBinaire.deciamlToBinaire(-1));
    }

    @Test
    void testMaxInteger() {
        assertEquals("1111111111111111111111111111111",
                DecimalToBinaire.deciamlToBinaire(Integer.MAX_VALUE));
    }

    @Test
    void testPowerOfTwo() {
        assertEquals("10000", DecimalToBinaire.deciamlToBinaire(16));
    }
}