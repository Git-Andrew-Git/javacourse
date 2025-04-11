package fr.javacourse;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void trouverMaxTest() {
        int[] res = Main.trouverMax(5, 3, 4);
        Assertions.assertEquals(3, res[0]);
    }

    @Test
    public void mainTest() {
        String res = Main.verifMaj("Boris", 17);
        Assertions.assertEquals("you are 17 years old, you are minor, access not granted", res);
    }

    @Test
    public void voyeConsTest() {

        boolean res = Main.voyeCons('i');
        Assertions.assertEquals(true, res);

    }

    @Test
    public void voyeConsNonLetterTest() {
        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Main.voyeCons('1');
        });
        Assertions.assertEquals("Input '1' is not a letter", exception.getMessage());
    }

    @Test
    public  void assezArgTest(){
        float res = Main.assezArg(500.00f, 353.55f);
        Assertions.assertEquals(146.45001f, res);
    }

    @Test
    public void tauxPartTest(){
        int res = Main.tauxPart('C', (short) 1, 1000, 'N');
        Assertions.assertEquals(35, res);
    }

    @Test
    public void youTubeTest(){
        double res = Main.youTube();
        Assertions.assertEquals(8062.50, res, 0.5);
    }
}
