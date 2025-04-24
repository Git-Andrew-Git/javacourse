package fr.javacourse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InserezChaineCaracterTest {

    @Test
    void testEmptyText() {
        StringBuilder result = InserezChaineCaracter.inserezChainCaracter("", "abc", 0);
        assertEquals("abc", result.toString());
    }

    @Test
    void testEmptyNewText() {
        StringBuilder result = InserezChaineCaracter.inserezChainCaracter("test", "", 0);
        assertEquals("", result.toString());
    }

    @Test
    void testCountEqualsTextLength() {
        StringBuilder result = InserezChaineCaracter.inserezChainCaracter("test", "abc", 4);
        assertEquals("abc", result.toString());
    }

    @Test
    void testCountGreaterThanTextLength() {
        StringBuilder result = InserezChaineCaracter.inserezChainCaracter("test", "abc", 5);
        assertEquals("abc", result.toString());
    }

    @Test
    void testSingleCharacterInsertion() {
        StringBuilder result = InserezChaineCaracter.inserezChainCaracter("t", "abc", 0);
        assertEquals("abt-c", result.toString());
    }

    @Test
    void testMultipleCharacterInsertion() {
        StringBuilder result = InserezChaineCaracter.inserezChainCaracter("test", "abc", 0);
        assertEquals("abt-ec-s-t", result.toString());
    }

    @Test
    void testInsertionAtMiddle() {
        StringBuilder result = InserezChaineCaracter.inserezChainCaracter("test", "abc", 2);
        assertEquals("abs-tc", result.toString());
    }

    @Test
    void testNullText() {
        assertThrows(NullPointerException.class, () -> {
            InserezChaineCaracter.inserezChainCaracter(null, "abc", 0);
        });
    }

    @Test
    void testNullNewText() {
        StringBuilder result = InserezChaineCaracter.inserezChainCaracter("test", null, 0);
        assertEquals("", result.toString());
    }

    @Test
    void testNegativeCount() {
        StringBuilder result = InserezChaineCaracter.inserezChainCaracter("test", "abc", -1);
        assertEquals("abt-ec-s-t", result.toString());
    }
}