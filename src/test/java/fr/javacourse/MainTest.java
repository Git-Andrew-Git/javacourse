package fr.javacourse;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {
    @Test
    public void trouverMaxTest() {
        int[] res = Main.trouverMax(5, 3, 4);
        assertEquals(3, res[0]);
    }

    @Test
    public void mainTest() {
        String res = Main.verifMaj("Boris", 17);
        assertEquals("you are 17 years old, you are minor, access not granted", res);
    }

    @Test
    public void voyeConsTest() {

        boolean res = Main.voyeCons('i');
        assertEquals(true, res);

    }

    @Test
    public void voyeConsNonLetterTest() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.voyeCons('1');
        });
        assertEquals("Input '1' is not a letter", exception.getMessage());
    }

    @Test
    public  void assezArgTest(){
        float res = Main.assezArg(500.00f, 353.55f);
        assertEquals(146.45001f, res);
    }

    @Test
    public void tauxPartTest(){
        int res = Main.tauxPart('C', (short) 1, 1000, 'N');
        assertEquals(35, res);
    }

    @Test
    public void youTubeTest(){
        double res = Main.youTube();
        assertEquals(8062.50, res, 0.5);
    }

    @Test
    public void somEntierTest() {

        String input = "3\n5\n4\nQ\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        int res = Main.somEntier(scanner);
        assertEquals(12, res);
    }

    @Test
    public void fuzzBuzzTest() {
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> res = Main.fuzzBuzz(scanner);
        ArrayList<String> exp = new ArrayList<>(Arrays.asList("1", "2", "Fuzz", "4", "Buzz"));
        assertEquals(exp, res);
    }

    @Test
    public void factorielleNTest(){
        String input = "5\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        long res = Main.factorielleN(scanner);
        assertEquals(120L, res);
    }
}
