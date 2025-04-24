package fr.javacourse;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

class JeuMastermindTest {

    @Test
    void testJeuMastermind() {
        assertFalse(JeuMastermind.jeuMastermind(new ArrayList<>(List.of(0)), new ArrayList<>(List.of(0)), 0));
    }
}
