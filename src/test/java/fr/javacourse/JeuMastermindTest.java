package fr.javacourse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class JeuMastermindTest {
    private ArrayList<Integer> combinaisonCachee;
    private ArrayList<Integer> propositionUtilisateur;

    @BeforeEach
    void setUp() {
        combinaisonCachee = new ArrayList<>();
        propositionUtilisateur = new ArrayList<>();
    }

    @Test
    void testCorrectCombination() {
        combinaisonCachee.addAll(new ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4)));
        propositionUtilisateur.addAll(new ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4)));
        assertTrue(JeuMastermind.jeuMastermind(combinaisonCachee, propositionUtilisateur, 1));
    }

    @Test
    void testIncorrectCombination() {
        combinaisonCachee.addAll(new ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4)));
        propositionUtilisateur.addAll(new ArrayList<>(java.util.Arrays.asList(5, 6, 7, 8)));
        assertFalse(JeuMastermind.jeuMastermind(combinaisonCachee, propositionUtilisateur, 1));
    }

    @Test
    void testPartiallyCorrectCombination() {
        combinaisonCachee.addAll(new ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4)));
        propositionUtilisateur.addAll(new ArrayList<>(java.util.Arrays.asList(1, 2, 5, 6)));
        assertFalse(JeuMastermind.jeuMastermind(combinaisonCachee, propositionUtilisateur, 1));
    }

    @Test
    void testMisplacedNumbers() {
        combinaisonCachee.addAll(new ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4)));
        propositionUtilisateur.addAll(new ArrayList<>(java.util.Arrays.asList(4, 3, 2, 1)));
        assertFalse(JeuMastermind.jeuMastermind(combinaisonCachee, propositionUtilisateur, 1));
    }

    @Test
    void testInvalidNumberRangeLow() {
        combinaisonCachee.addAll(new ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4)));
        propositionUtilisateur.addAll(new ArrayList<>(java.util.Arrays.asList(-1, 2, 3, 4)));
        assertFalse(JeuMastermind.jeuMastermind(combinaisonCachee, propositionUtilisateur, 1));
    }

    @Test
    void testInvalidNumberRangeHigh() {
        combinaisonCachee.addAll(new ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4)));
        propositionUtilisateur.addAll(new ArrayList<>(java.util.Arrays.asList(8, 2, 3, 4)));
        assertFalse(JeuMastermind.jeuMastermind(combinaisonCachee, propositionUtilisateur, 1));
    }

    @Test
    void testWrongSizeProposition() {
        combinaisonCachee.addAll(new ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4)));
        propositionUtilisateur.addAll(new ArrayList<>(java.util.Arrays.asList(1, 2, 3)));
        assertFalse(JeuMastermind.jeuMastermind(combinaisonCachee, propositionUtilisateur, 1));
    }

    @Test
    void testEmptyProposition() {
        combinaisonCachee.addAll(new ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4)));
        propositionUtilisateur.clear();
        assertFalse(JeuMastermind.jeuMastermind(combinaisonCachee, propositionUtilisateur, 1));
    }

    @Test
    void testZeroTries() {
        combinaisonCachee.addAll(new ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4)));
        propositionUtilisateur.addAll(new ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4)));
        assertFalse(JeuMastermind.jeuMastermind(combinaisonCachee, propositionUtilisateur, 0));
    }

    @Test
    void testMultipleTriesExhausted() {
        combinaisonCachee.addAll(new ArrayList<>(java.util.Arrays.asList(1, 2, 3, 4)));
        propositionUtilisateur.addAll(new ArrayList<>(java.util.Arrays.asList(5, 6, 7, 8)));
        assertFalse(JeuMastermind.jeuMastermind(combinaisonCachee, propositionUtilisateur, 3));
    }
}