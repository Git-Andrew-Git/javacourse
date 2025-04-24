package fr.javacourse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class AlgorithmeGloutonTest {

    @Test
    void testAlgorithmeGlouton() {
        assertArrayEquals(new int[]{0, 0, 0, 1, 0, 1, 0, 0}, AlgorithmeGlouton.algorithmeGlouton(25));
    }

    @Test
    void testZeroInput() {
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, AlgorithmeGlouton.algorithmeGlouton(0));
    }

    @Test
    void testNegativeInput() {
        assertArrayEquals(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, AlgorithmeGlouton.algorithmeGlouton(-5));
    }

    @Test
    void testAllDenominations() {
        assertArrayEquals(new int[]{1, 1, 1, 1, 1, 1, 1, 1}, AlgorithmeGlouton.algorithmeGlouton(388));
    }

    @Test
    void testPartialDenominations() {
        assertArrayEquals(new int[]{0, 0, 1, 0, 0, 1, 0, 0}, AlgorithmeGlouton.algorithmeGlouton(55));
    }

    @Test
    void testLargeInput() {
        assertArrayEquals(new int[]{4, 1, 1, 2, 0, 1, 2, 0}, AlgorithmeGlouton.algorithmeGlouton(999));
    }
}
