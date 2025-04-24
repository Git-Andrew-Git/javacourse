package fr.javacourse;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class SommeElementsTableauTest {

    @Test
    void testEmptyArrayList() {
        ArrayList<Integer> tableau = new ArrayList<>();
        int result = SommeElementsTableau.sommeElementsTableau(tableau, 0);
        assertEquals(0, result, "Empty ArrayList should return 0");
    }

    @Test
    void testSingleElement() {
        ArrayList<Integer> tableau = new ArrayList<>();
        tableau.add(5);
        int result = SommeElementsTableau.sommeElementsTableau(tableau, 0);
        assertEquals(5, result, "Single element ArrayList should return the element value");
    }

    @Test
    void testMultipleElements() {
        ArrayList<Integer> tableau = new ArrayList<>();
        tableau.add(1);
        tableau.add(2);
        tableau.add(3);
        int result = SommeElementsTableau.sommeElementsTableau(tableau, 0);
        assertEquals(6, result, "Multiple elements should return their sum");
    }

    @Test
    void testIndiceAtSize() {
        ArrayList<Integer> tableau = new ArrayList<>();
        tableau.add(1);
        tableau.add(2);
        int result = SommeElementsTableau.sommeElementsTableau(tableau, 2);
        assertEquals(0, result, "Indice equal to size should return 0");
    }

    @Test
    void testIndiceBeyondSize() {
        ArrayList<Integer> tableau = new ArrayList<>();
        tableau.add(1);
        int result = SommeElementsTableau.sommeElementsTableau(tableau, 5);
        assertEquals(0, result, "Indice beyond size should return 0");
    }

    @Test
    void testNegativeNumbers() {
        ArrayList<Integer> tableau = new ArrayList<>();
        tableau.add(-1);
        tableau.add(-2);
        tableau.add(-3);
        int result = SommeElementsTableau.sommeElementsTableau(tableau, 0);
        assertEquals(-6, result, "Negative numbers should sum correctly");
    }

    @Test
    void testMixedNumbers() {
        ArrayList<Integer> tableau = new ArrayList<>();
        tableau.add(-1);
        tableau.add(0);
        tableau.add(1);
        int result = SommeElementsTableau.sommeElementsTableau(tableau, 0);
        assertEquals(0, result, "Mixed positive, negative, and zero should sum correctly");
    }

    @Test
    void testStartFromMiddleIndex() {
        ArrayList<Integer> tableau = new ArrayList<>();
        tableau.add(1);
        tableau.add(2);
        tableau.add(3);
        tableau.add(4);
        int result = SommeElementsTableau.sommeElementsTableau(tableau, 2);
        assertEquals(7, result, "Starting from middle index should sum remaining elements");
    }
}