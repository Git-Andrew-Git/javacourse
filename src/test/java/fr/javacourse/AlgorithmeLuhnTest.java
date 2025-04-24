package fr.javacourse;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmeLuhnTest {

    // Tests for specific cases provided
    @Test
    public void testCorrectCardNumber1() {
        ArrayList<Integer> cardNumber = new ArrayList<>(Arrays.asList(4,2,6,3,9,8,2,6,4,0,2,6,9,2,9,9));
        assertTrue(AlgorithmeLuhn.algorithmeLuhn(cardNumber));
    }

    @Test
    public void testCorrectCardNumber2() {
        ArrayList<Integer> cardNumber = new ArrayList<>(Arrays.asList(4,5,3,9,3,1,9,5,0,3,4,3,6,4,6,7));
        assertTrue(AlgorithmeLuhn.algorithmeLuhn(cardNumber));
    }

    @Test
    public void testCorrectCardNumber3() {
        ArrayList<Integer> cardNumber = new ArrayList<>(Arrays.asList(7,9,9,2,7,3,9,8,7,1,3));
        assertTrue(AlgorithmeLuhn.algorithmeLuhn(cardNumber));
    }

    @Test
    public void testIncorrectCardNumber1() {
        ArrayList<Integer> cardNumber = new ArrayList<>(Arrays.asList(4,2,2,3,9,8,2,6,4,0,2,6,9,2,9,9));
        assertFalse(AlgorithmeLuhn.algorithmeLuhn(cardNumber));
    }

    @Test
    public void testIncorrectCardNumber2() {
        ArrayList<Integer> cardNumber = new ArrayList<>(Arrays.asList(4,5,3,9,3,1,9,5,0,3,4,3,6,4,7,6));
        assertFalse(AlgorithmeLuhn.algorithmeLuhn(cardNumber));
    }

    @Test
    public void testIncorrectCardNumber3() {
        ArrayList<Integer> cardNumber = new ArrayList<>(Arrays.asList(8,2,7,3,1,2,3,2,7,3,5,2,0,5,6,9));
        assertFalse(AlgorithmeLuhn.algorithmeLuhn(cardNumber));
    }

    // Full coverage tests
    @Test
    public void testEmptyCardNumber() {
        ArrayList<Integer> cardNumber = new ArrayList<>();
        assertFalse(AlgorithmeLuhn.algorithmeLuhn(cardNumber));
    }

    @Test
    public void testSingleDigitCardNumber() {
        ArrayList<Integer> cardNumber = new ArrayList<>(Arrays.asList(5));
        assertFalse(AlgorithmeLuhn.algorithmeLuhn(cardNumber));
    }

    @Test
    public void testAllZeros() {
        ArrayList<Integer> cardNumber = new ArrayList<>(Arrays.asList(0,0,0,0));
        assertTrue(AlgorithmeLuhn.algorithmeLuhn(cardNumber));
    }

    @Test
    public void testDoubleDigitAfterMultiplication() {
        // Designed to trigger temperaire >= 10 case
        ArrayList<Integer> cardNumber = new ArrayList<>(Arrays.asList(9,9,9,9));
        assertFalse(AlgorithmeLuhn.algorithmeLuhn(cardNumber));
    }

    @Test
    public void testOddLengthCardNumber() {
        ArrayList<Integer> cardNumber = new ArrayList<>(Arrays.asList(1,2,3,4,5));
        assertFalse(AlgorithmeLuhn.algorithmeLuhn(cardNumber));
    }

    @Test
    public void testEvenLengthCardNumber() {
        ArrayList<Integer> cardNumber = new ArrayList<>(Arrays.asList(1,2,3,4));
        assertFalse(AlgorithmeLuhn.algorithmeLuhn(cardNumber));
    }

//testMaximumSingleDigitAfterMultiplication est 9, est imposssible


    @Test
    public void testMinimumSingleDigitAfterMultiplication() {
        // Tests case where doubled number is 0
        ArrayList<Integer> cardNumber = new ArrayList<>(Arrays.asList(0,0,0,9,5,0));
        assertTrue(AlgorithmeLuhn.algorithmeLuhn(cardNumber));
    }
}