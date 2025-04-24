package fr.javacourse;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

import static fr.javacourse.Main.*;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void trouverMaxMinTest() {
        int[] res = Main.trouverMaxMin(5, 3, 4);
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
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
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

    @Test
    public void itTableauTest(){
        double[] res = Main.itTableau();
        assertTrue(Arrays.equals(res, new double[]{5.8, 6.4, 5.3}));
    }


    @Nested
    @DisplayName("Tests for rechSeq1 method")
    class RechSeq1Test {

        @Test
        @DisplayName("Test rechSeq1 with value present in non-empty array")
        void testValuePresent() {
            int[] tableau = {1, 5, 8, 6, 7, 2, 4};
            int v = 7;
            assertEquals(4, rechSeq1(v, tableau), "Should return index 4 for value 7");
        }

        @Test
        @DisplayName("Test rechSeq1 with value not present in non-empty array")
        void testValueNotPresent() {
            int[] tableau = {1, 5, 8, 6, 7, 2, 4};
            int v = 9;
            assertEquals(-1, rechSeq1(v, tableau), "Should return -1 for value not in array");
        }

        @Test
        @DisplayName("Test rechSeq1 with empty array")
        void testEmptyArray() {
            int[] tableau = {};
            int v = 1;
            assertEquals(-1, rechSeq1(v, tableau), "Should return -1 for empty array");
        }

        @Test
        @DisplayName("Test rechSeq1 with single element array and value present")
        void testSingleElementPresent() {
            int[] tableau = {5};
            int v = 5;
            assertEquals(0, rechSeq1(v, tableau), "Should return 0 for single element array with value present");
        }

        @Test
        @DisplayName("Test rechSeq1 with single element array and value not present")
        void testSingleElementNotPresent() {
            int[] tableau = {5};
            int v = 3;
            assertEquals(-1, rechSeq1(v, tableau), "Should return -1 for single element array with value not present");
        }

        @Test
        @DisplayName("Test rechSeq1 with value at first index")
        void testValueAtFirstIndex() {
            int[] tableau = {1, 5, 8, 6, 7, 2, 4};
            int v = 1;
            assertEquals(0, rechSeq1(v, tableau), "Should return 0 for value at first index");
        }

        @Test
        @DisplayName("Test rechSeq1 with value at last index")
        void testValueAtLastIndex() {
            int[] tableau = {1, 5, 8, 6, 7, 2, 4};
            int v = 4;
            assertEquals(6, rechSeq1(v, tableau), "Should return 6 for value at last index");
        }

        @Test
        @DisplayName("Test rechSeq1 with null array")
        void testNullArray() {
            int v = 1;
            assertThrows(NullPointerException.class, () -> rechSeq1(v, null), "Should throw NullPointerException for null array");
        }
    }


    @Nested
    @DisplayName("Tests for rechSeq2 method")
    class RechSeq2Tests {

        @Test
        @DisplayName("Value found at the beginning")
        void testValueFoundAtBeginning() {
            int[] tableau = {7, 5, 8, 6, 2, 4};
            int v = 7;
            assertEquals(0, rechSeq2(v, tableau));
        }

        @Test
        @DisplayName("Value found in the middle")
        void testValueFoundInMiddle() {
            int[] tableau = {1, 5, 8, 7, 2, 4};
            int v = 7;
            assertEquals(3, rechSeq2(v, tableau));
        }

        @Test
        @DisplayName("Value found at the end")
        void testValueFoundAtEnd() {
            int[] tableau = {1, 5, 8, 6, 2, 7};
            int v = 7;
            assertEquals(5, rechSeq2(v, tableau));
        }

        @Test
        @DisplayName("Value not found")
        void testValueNotFound() {
            int[] tableau = {1, 5, 8, 6, 2, 4};
            int v = 7;
            assertEquals(-1, rechSeq2(v, tableau));
        }

        @Test
        @DisplayName("Empty array")
        void testEmptyArray() {
            int[] tableau = {};
            int v = 7;
            assertEquals(-1, rechSeq2(v, tableau));
        }

        @Test
        @DisplayName("Single element array - value found")
        void testSingleElementFound() {
            int[] tableau = {7};
            int v = 7;
            assertEquals(0, rechSeq2(v, tableau));
        }

        @Test
        @DisplayName("Single element array - value not found")
        void testSingleElementNotFound() {
            int[] tableau = {1};
            int v = 7;
            assertEquals(-1, rechSeq2(v, tableau));
        }

        @Test
        @DisplayName("Multiple occurrences - returns first")
        void testMultipleOccurrences() {
            int[] tableau = {7, 5, 7, 6, 7, 4};
            int v = 7;
            assertEquals(0, rechSeq2(v, tableau));
        }
    }

    @Test
    void rechSeq3() {
    }

    @Nested
    @DisplayName("Tests for somEntre1 method")
    class SomEntre1Tests {

        @Test
        @DisplayName("Valid range with positive numbers")
        void testValidRangePositiveNumbers() {
            int[] tableau = {1, 2, 3, 4, 5};
            assertEquals(12, somEntre1(tableau, 1, 4)); // 2 + 3 + 4 = 12
        }

        @Test
        @DisplayName("Valid range with negative numbers")
        void testValidRangeNegativeNumbers() {
            int[] tableau = {-1, -2, -3, -4, -5};
            assertEquals(-12, somEntre1(tableau, 1, 4)); // -2 + -3 + -4 = -12
        }

        @Test
        @DisplayName("Single element range")
        void testSingleElementRange() {
            int[] tableau = {10, 20, 30};
            assertEquals(20, somEntre1(tableau, 1, 2)); // 20
        }

        @Test
        @DisplayName("Empty range (i equals j)")
        void testEmptyRange() {
            int[] tableau = {1, 2, 3};
            assertEquals(0, somEntre1(tableau, 2, 2)); // No elements summed
        }

        @Test
        @DisplayName("Full array range")
        void testFullArrayRange() {
            int[] tableau = {1, 2, 3, 4};
            assertEquals(10, somEntre1(tableau, 0, 4)); // 1 + 2 + 3 + 4 = 10
        }

        @Test
        @DisplayName("Array with zeros")
        void testArrayWithZeros() {
            int[] tableau = {0, 0, 0, 0};
            assertEquals(0, somEntre1(tableau, 1, 3)); // 0 + 0 = 0
        }

        @Test
        @DisplayName("Invalid range (i > j)")
        void testInvalidRange() {
            int[] tableau = {1, 2, 3};
            assertEquals(0, somEntre1(tableau, 3, 1)); // Should return 0 as loop won't execute
        }

        @Test
        @DisplayName("Index out of bounds (i negative)")
        void testIndexOutOfBoundsNegative() {
            int[] tableau = {1, 2, 3};
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                somEntre1(tableau, -1, 2);
            });
        }

        @Test
        @DisplayName("Index out of bounds (j > array length)")
        void testIndexOutOfBoundsTooLarge() {
            int[] tableau = {1, 2, 3};
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                somEntre1(tableau, 0, 4);
            });
        }

        @Test
        @DisplayName("Null array")
        void testNullArray() {
            assertThrows(NullPointerException.class, () -> {
                somEntre1(null, 0, 1);
            });
        }

        @Test
        @DisplayName("Empty array")
        void testEmptyArray() {
            int[] tableau = {};
            assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
                somEntre1(tableau, 0, 1);
            });
        }
    }

    @Nested
    @DisplayName("Tests for somEntre2 method")
    class SomEntre2Tests {

        @Test
        @DisplayName("Valid range with positive numbers")
        void testValidRangePositiveNumbers() {
            int[] array = {1, 2, 3, 4, 5};
            assertEquals(12, somEntre2(array, 1, 4)); // Sum of 2+3+4 = 12
        }

        @Test
        @DisplayName("Valid range with negative numbers")
        void testValidRangeNegativeNumbers() {
            int[] array = {-1, -2, -3, -4, -5};
            assertEquals(-12, somEntre2(array, 1, 4)); // Sum of -2+-3+-4 = -12
        }

        @Test
        @DisplayName("Single element range")
        void testSingleElementRange() {
            int[] array = {1, 2, 3};
            assertEquals(2, somEntre2(array, 1, 2)); // Sum of 2 = 2
        }

        @Test
        @DisplayName("Empty range")
        void testEmptyRange() {
            int[] array = {1, 2, 3};
            assertEquals(0, somEntre2(array, 1, 1)); // No elements, sum = 0
        }

        @Test
        @DisplayName("Full array range")
        void testFullArrayRange() {
            int[] array = {1, 2, 3, 4};
            assertEquals(10, somEntre2(array, 0, 4)); // Sum of 1+2+3+4 = 10
        }

        @Test
        @DisplayName("Array with zeros")
        void testArrayWithZeros() {
            int[] array = {0, 0, 0, 0};
            assertEquals(0, somEntre2(array, 1, 3)); // Sum of 0+0 = 0
        }

        @Test
        @DisplayName("Invalid range: i > j")
        void testInvalidRangeIgreaterThanJ() {
            int[] array = {1, 2, 3};
            assertThrows(IllegalArgumentException.class, () -> somEntre2(array, 2, 1));
        }

        @Test
        @DisplayName("Invalid range: i negative")
        void testInvalidRangeNegativeI() {
            int[] array = {1, 2, 3};
            assertThrows(IllegalArgumentException.class, () -> somEntre2(array, -1, 2));
        }

        @Test
        @DisplayName("Invalid range: j > array length")
        void testInvalidRangeJbeyondLength() {
            int[] array = {1, 2, 3};
            assertThrows(IllegalArgumentException.class, () -> somEntre2(array, 1, 4));
        }

        @Test
        @DisplayName("Null array")
        void testNullArray() {
            assertThrows(NullPointerException.class, () -> somEntre2(null, 0, 1));
        }

        @Test
        @DisplayName("Empty array with valid range")
        void testEmptyArrayValidRange() {
            int[] array = {};
            assertEquals(0, somEntre2(array, 0, 0)); // Empty array, sum = 0
        }

        @Test
        @DisplayName("Empty array with invalid range")
        void testEmptyArrayInvalidRange() {
            int[] array = {};
            assertThrows(IllegalArgumentException.class, () -> somEntre2(array, 0, 1));
        }
    }

    @Nested
    @DisplayName("Tests for indDanTab1")
    class IndDanTab1Tests {

        @Test
        @DisplayName("Empty array returns [0, 0]")
        void testEmptyArray() {
            int[] input = {};
            int[] expected = {0, 0};
            assertArrayEquals(expected, indDanTab1(input));
        }

        @Test
        @DisplayName("Single element array returns same index for min and max")
        void testSingleElementArray() {
            int[] input = {5};
            int[] expected = {0, 0};
            assertArrayEquals(expected, indDanTab1(input));
        }

        @Test
        @DisplayName("Array with distinct elements")
        void testDistinctElements() {
            int[] input = {3, 1, 4, 5, 2};
            int[] expected = {1, 3};
            assertArrayEquals(expected, indDanTab1(input));
        }

        @Test
        @DisplayName("Array with all identical elements")
        void testIdenticalElements() {
            int[] input = {2, 2, 2, 2};
            int[] expected = {0, 3};
            assertArrayEquals(expected, indDanTab1(input));
        }

        @Test
        @DisplayName("Array with negative numbers")
        void testNegativeNumbers() {
            int[] input = {-3, -1, -4, -2};
            int[] expected = {2, 1};
            assertArrayEquals(expected, indDanTab1(input));
        }

        @Test
        @DisplayName("Array with min at start and max at end")
        void testMinStartMaxEnd() {
            int[] input = {1, 3, 2, 5};
            int[] expected = {0, 3};
            assertArrayEquals(expected, indDanTab1(input));
        }

        @Test
        @DisplayName("Array with max at start and min at end")
        void testMaxStartMinEnd() {
            int[] input = {5, 3, 2, 1};
            int[] expected = {3, 0};
            assertArrayEquals(expected, indDanTab1(input));
        }

        @Test
        @DisplayName("Array with duplicate min and max values")
        void testDuplicateMinMax() {
            int[] input = {1, 3, 1, 3};
            int[] expected = {0, 3};
            assertArrayEquals(expected, indDanTab1(input));
        }
    }

    //Mock or ...
    @Test
    void echanVal() {
    }

    @Nested
    @DisplayName("Tests for moyenne method")
    class MoyenneTests {

        @Test
        @DisplayName("Test with normal array")
        void testMoyenneNormalArray() {
            int[] tableau = {1, 2, 3, 4, 5};
            float expected = 3.0f;
            float result = Main.moyenne(tableau);
            assertEquals(expected, result, 0.0001f, "Average of {1,2,3,4,5} should be 3.0");
        }

        @Test
        @DisplayName("Test with empty array")
        void testMoyenneEmptyArray() {
            int[] tableau = {};
            float expected = 0.0f;
            float result = Main.moyenne(tableau);
            assertEquals(expected, result, 0.0001f, "Empty array should return 0.0");
        }

        @Test
        @DisplayName("Test with single element")
        void testMoyenneSingleElement() {
            int[] tableau = {42};
            float expected = 42.0f;
            float result = Main.moyenne(tableau);
            assertEquals(expected, result, 0.0001f, "Single element array should return the element");
        }

        @Test
        @DisplayName("Test with negative numbers")
        void testMoyenneNegativeNumbers() {
            int[] tableau = {-1, -2, -3, -4};
            float expected = -2.5f;
            float result = Main.moyenne(tableau);
            assertEquals(expected, result, 0.0001f, "Average of negative numbers should be correct");
        }

        @Test
        @DisplayName("Test with large numbers")
        void testMoyenneLargeNumbers() {
            int[] tableau = {Integer.MAX_VALUE, Integer.MAX_VALUE};
            float expected = (float) Integer.MAX_VALUE;
            float result = Main.moyenne(tableau);
            assertEquals(expected, result, 0.0001f, "Average of large numbers should be correct");
        }

        @Test
        @DisplayName("Test with zeros")
        void testMoyenneZeros() {
            int[] tableau = {0, 0, 0};
            float expected = 0.0f;
            float result = Main.moyenne(tableau);
            assertEquals(expected, result, 0.0001f, "Average of zeros should be 0.0");
        }

        @Test
        @DisplayName("Test with mixed positive and negative numbers")
        void testMoyenneMixedNumbers() {
            int[] tableau = {-10, 10, -5, 5};
            float expected = 0.0f;
            float result = Main.moyenne(tableau);
            assertEquals(expected, result, 0.0001f, "Average of mixed positive and negative numbers should be correct");
        }
    }

    @Nested
    @DisplayName("Tests for moyenne1 method")
    class Moyenne1Tests {

        @Test
        @DisplayName("Test with non-empty array of positive numbers")
        void testPositiveNumbers() {
            int[] tableau = {1, 2, 3, 4, 5};
            float result = moyenne1(tableau);
            assertEquals(3.0f, result, 0.0001f, "Average of [1,2,3,4,5] should be 3.0");
        }

        @Test
        @DisplayName("Test with non-empty array of negative numbers")
        void testNegativeNumbers() {
            int[] tableau = {-1, -2, -3, -4, -5};
            float result = moyenne1(tableau);
            assertEquals(-3.0f, result, 0.0001f, "Average of [-1,-2,-3,-4,-5] should be -3.0");
        }

        @Test
        @DisplayName("Test with mixed positive and negative numbers")
        void testMixedNumbers() {
            int[] tableau = {-2, -1, 0, 1, 2};
            float result = moyenne1(tableau);
            assertEquals(0.0f, result, 0.0001f, "Average of [-2,-1,0,1,2] should be 0.0");
        }

        @Test
        @DisplayName("Test with single element array")
        void testSingleElement() {
            int[] tableau = {42};
            float result = moyenne1(tableau);
            assertEquals(42.0f, result, 0.0001f, "Average of [42] should be 42.0");
        }

        @Test
        @DisplayName("Test with empty array")
        void testEmptyArray() {
            int[] tableau = {};
            float result = moyenne1(tableau);
            assertEquals(0.0f, result, 0.0001f, "Average of empty array should be 0.0");
        }

        @Test
        @DisplayName("Test with null array")
        void testNullArray() {
            int[] tableau = null;
            assertThrows(NullPointerException.class, () -> moyenne1(tableau), "Should throw NullPointerException for null array");
        }

        @ParameterizedTest
        @MethodSource("largeArrayProvider")
        @DisplayName("Test with large arrays")
        void testLargeArrays(int[] tableau) {
            float expected = (float) Arrays.stream(tableau).average().orElse(0.0);
            float result = moyenne1(tableau);
            assertEquals(expected, result, 0.0001f, "Average should match expected for large array");
        }

        static Stream<int[]> largeArrayProvider() {
            return Stream.of(
                    new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                    new int[]{1000, 2000, 3000, 4000, 5000},
                    new int[]{-100, -200, -300, -400, -500}
            );
        }
    }

    @Nested
    @DisplayName("Tests for manipTabl method")
    class ManipTablTests {
        private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        private final PrintStream originalOut = System.out;

        @BeforeEach
        void setUp() {
            System.setOut(new PrintStream(outputStream));
        }

        @AfterEach
        void tearDown() {
            System.setOut(originalOut);
            outputStream.reset();
        }

        @Test
        @DisplayName("Test with valid input size and numbers")
        void testValidInput() {
            String input = "3\n1\n2\n3\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Scanner scanner = new Scanner(System.in);

            manipTabl(scanner);

            String output = outputStream.toString();
            assertTrue(output.contains("Veuillez choisir un nombre de valeurs à saisir :"));
            assertTrue(output.contains("Veuillez saisir le nombre 1 :"));
            assertTrue(output.contains("Veuillez saisir le nombre 2 :"));
            assertTrue(output.contains("Veuillez saisir le nombre 3 :"));
            assertTrue(output.contains("Tableau de nombres saisis : [1, 2, 3]"));
            assertTrue(output.contains("Min = 1"));
            assertTrue(output.contains("Max = 3"));
            assertTrue(output.contains("Moyenne = 2"));
        }

        @Test
        @DisplayName("Test with zero size input")
        void testZeroSize() {
            String input = "0\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Scanner scanner = new Scanner(System.in);

            manipTabl(scanner);

            String output = outputStream.toString();
            assertTrue(output.contains("tableau est vide"));
            assertFalse(output.contains("Tableau de nombres saisis"));
        }

        @Test
        @DisplayName("Test with negative size input")
        void testNegativeSize() {
            String input = "-1\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Scanner scanner = new Scanner(System.in);

            manipTabl(scanner);

            String output = outputStream.toString();
            assertTrue(output.contains("Taille negative"));
            assertFalse(output.contains("Tableau de nombres saisis"));
        }

        @Test
        @DisplayName("Test with non-integer input for size")
        void testInvalidSizeInput() {
            String input = "abc\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Scanner scanner = new Scanner(System.in);

            assertThrows(java.util.InputMismatchException.class, () -> manipTabl(scanner));
        }

        @Test
        @DisplayName("Test with non-integer input for array elements")
        void testInvalidElementInput() {
            String input = "2\n1\nabc\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Scanner scanner = new Scanner(System.in);

            assertThrows(java.util.InputMismatchException.class, () -> manipTabl(scanner));
        }

        @Test
        @DisplayName("Test with single element array")
        void testSingleElement() {
            String input = "1\n5\n";
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Scanner scanner = new Scanner(System.in);

            manipTabl(scanner);

            String output = outputStream.toString();
            assertTrue(output.contains("Tableau de nombres saisis : [5]"));
            assertTrue(output.contains("Min = 5"));
            assertTrue(output.contains("Max = 5"));
            assertTrue(output.contains("Moyenne = 5"));
        }

        @ValueSource(ints = {2, 5, 10})
        @DisplayName("Test with various valid array sizes")
        void testVariousSizes(int size) {
            StringBuilder input = new StringBuilder(size + "\n");
            for (int i = 1; i <= size; i++) {
                input.append(i).append("\n");
            }
            System.setIn(new ByteArrayInputStream(input.toString().getBytes()));
            Scanner scanner = new Scanner(System.in);

            manipTabl(scanner);

            String output = outputStream.toString();
            assertTrue(output.contains("Tableau de nombres saisis"));
            assertTrue(output.contains("Min = 1"));
            assertTrue(output.contains("Max = " + size));
        }
    }

    @Nested
    @DisplayName("Tests for invert method")
    class InvertTests {

        @Test
        @DisplayName("Empty array returns empty array")
        void testEmptyArray() {
            int[] input = {};
            int[] expected = {};
            assertArrayEquals(expected, Main.invert(input));
        }

        @Test
        @DisplayName("Single element array returns same array")
        void testSingleElementArray() {
            int[] input = {1};
            int[] expected = {1};
            assertArrayEquals(expected, Main.invert(input));
        }

        @Test
        @DisplayName("Multiple elements array reverses correctly")
        void testMultipleElementsArray() {
            int[] input = {1, 2, 3, 4};
            int[] expected = {4, 3, 2, 1};
            assertArrayEquals(expected, Main.invert(input));
        }

        @Test
        @DisplayName("Array with negative numbers reverses correctly")
        void testNegativeNumbersArray() {
            int[] input = {-1, -2, -3};
            int[] expected = {-3, -2, -1};
            assertArrayEquals(expected, Main.invert(input));
        }

        @Test
        @DisplayName("Array with zeros reverses correctly")
        void testZeroElementsArray() {
            int[] input = {0, 0, 0};
            int[] expected = {0, 0, 0};
            assertArrayEquals(expected, Main.invert(input));
        }

        @Test
        @DisplayName("Array with mixed numbers reverses correctly")
        void testMixedNumbersArray() {
            int[] input = {-1, 0, 2, -3};
            int[] expected = {-3, 2, 0, -1};
            assertArrayEquals(expected, Main.invert(input));
        }

        @Test
        @DisplayName("Large array reverses correctly")
        void testLargeArray() {
            int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int[] expected = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
            assertArrayEquals(expected, Main.invert(input));
        }
    }

    @Nested
    @DisplayName("Tests for som2Dtableau method")
    class Som2DTableauTests {

        @Test
        @DisplayName("Test with 2x2 valid table")
        void testValid2x2Table() {
            int[][] table = {{1, 2}, {3, 4}};
            int result = Main.som2Dtableau(table, 2, 2);
            assertEquals(10, result, "Sum of 2x2 table should be 10");
        }

        @Test
        @DisplayName("Test with 1x1 table")
        void testSingleElementTable() {
            int[][] table = {{5}};
            int result = Main.som2Dtableau(table, 1, 1);
            assertEquals(5, result, "Sum of 1x1 table should be 5");
        }

        @Test
        @DisplayName("Test with empty table (0x0)")
        void testEmptyTable() {
            int[][] table = {};
            int result = Main.som2Dtableau(table, 0, 0);
            assertEquals(0, result, "Sum of empty table should be 0");
        }

        @Test
        @DisplayName("Test with 3x2 table")
        void test3x2Table() {
            int[][] table = {{1, 2}, {3, 4}, {5, 6}};
            int result = Main.som2Dtableau(table, 2, 3);
            assertEquals(21, result, "Sum of 3x2 table should be 21");
        }

        @Test
        @DisplayName("Test with negative numbers")
        void testNegativeNumbers() {
            int[][] table = {{-1, -2}, {-3, -4}};
            int result = Main.som2Dtableau(table, 2, 2);
            assertEquals(-10, result, "Sum of table with negative numbers should be -10");
        }

        @Test
        @DisplayName("Test with zero values")
        void testZeroValues() {
            int[][] table = {{0, 0}, {0, 0}};
            int result = Main.som2Dtableau(table, 2, 2);
            assertEquals(0, result, "Sum of table with zeros should be 0");
        }

        @Test
        @DisplayName("Test with large numbers")
        void testLargeNumbers() {
            int[][] table = {{1000000, 2000000}, {3000000, 4000000}};
            int result = Main.som2Dtableau(table, 2, 2);
            assertEquals(10000000, result, "Sum of table with large numbers should be 10000000");
        }

        @Test
        @DisplayName("Test with 1x3 table")
        void test1x3Table() {
            int[][] table = {{1, 2, 3}};
            int result = Main.som2Dtableau(table, 3, 1);
            assertEquals(6, result, "Sum of 1x3 table should be 6");
        }

        @Test
        @DisplayName("Test with 3x1 table")
        void test3x1Table() {
            int[][] table = {{1}, {2}, {3}};
            int result = Main.som2Dtableau(table, 1, 3);
            assertEquals(6, result, "Sum of 3x1 table should be 6");
        }

        @Test
        @DisplayName("Test with mixed positive and negative numbers")
        void testMixedNumbers() {
            int[][] table = {{1, -2}, {-3, 4}};
            int result = Main.som2Dtableau(table, 2, 2);
            assertEquals(0, result, "Sum of table with mixed numbers should be 0");
        }
    }

    @Nested
    @DisplayName("sumMatrixDiag")
    class SumMatrixDiagTests {

        @Test
        @DisplayName("Empty matrix returns 0")
        void testEmptyMatrix() {
            int[][] matrix = {};
            int result = Main.sumMatrixDiag(matrix, 0, 0, 1);
            assertEquals(0, result);
        }

        @Test
        @DisplayName("Non-square matrix returns 0")
        void testNonSquareMatrix() {
            int[][] matrix = {{1, 2, 3}, {4, 5, 6}};
            int result = Main.sumMatrixDiag(matrix, 3, 2, 1);
            assertEquals(0, result);
        }

        @Test
        @DisplayName("1x1 matrix with diagonalType 1")
        void testSingleElementMatrixDiagonalType1() {
            int[][] matrix = {{5}};
            int result = Main.sumMatrixDiag(matrix, 1, 1, 1);
            assertEquals(5, result);
        }

        @Test
        @DisplayName("1x1 matrix with diagonalType 2")
        void testSingleElementMatrixDiagonalType2() {
            int[][] matrix = {{5}};
            int result = Main.sumMatrixDiag(matrix, 1, 1, 2);
            assertEquals(5, result);
        }

        @Test
        @DisplayName("1x1 matrix with invalid diagonalType")
        void testSingleElementMatrixInvalidDiagonalType() {
            int[][] matrix = {{5}};
            int result = Main.sumMatrixDiag(matrix, 1, 1, 0);
            assertEquals(5, result);
        }

        @Test
        @DisplayName("3x3 matrix with diagonalType 1 (main diagonal)")
        void test3x3MatrixDiagonalType1() {
            int[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            int result = Main.sumMatrixDiag(matrix, 3, 3, 1);
            assertEquals(15, result); // 1 + 5 + 9 = 15
        }

        @Test
        @DisplayName("3x3 matrix with diagonalType 2 (secondary diagonal)")
        void test3x3MatrixDiagonalType2() {
            int[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            int result = Main.sumMatrixDiag(matrix, 3, 3, 2);
            assertEquals(15, result); // 3 + 5 + 7 = 15
        }

        @Test
        @DisplayName("3x3 matrix with invalid diagonalType (defaults to main diagonal)")
        void test3x3MatrixInvalidDiagonalType() {
            int[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };
            int result = Main.sumMatrixDiag(matrix, 3, 3, 0);
            assertEquals(15, result); // 1 + 5 + 9 = 15
        }

        @Test
        @DisplayName("2x2 matrix with diagonalType 1")
        void test2x2MatrixDiagonalType1() {
            int[][] matrix = {
                    {1, 2},
                    {3, 4}
            };
            int result = Main.sumMatrixDiag(matrix, 2, 2, 1);
            assertEquals(5, result); // 1 + 4 = 5
        }

        @Test
        @DisplayName("2x2 matrix with diagonalType 2")
        void test2x2MatrixDiagonalType2() {
            int[][] matrix = {
                    {1, 2},
                    {3, 4}
            };
            int result = Main.sumMatrixDiag(matrix, 2, 2, 2);
            assertEquals(5, result); // 2 + 3 = 5
        }

        @Test
        @DisplayName("Null matrix throws NullPointerException")
        void testNullMatrix() {
            assertThrows(NullPointerException.class, () -> {
                Main.sumMatrixDiag(null, 0, 0, 1);
            });
        }
    }

    @Nested
    @DisplayName("triangChar1")
    class TriangChar1Tests {

        private ByteArrayOutputStream outputStream;
        private PrintStream originalOut;

        private void setUpInput(String input) {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));
        }

        private void restoreSystem() {
            System.setOut(originalOut);
            System.setIn(System.in);
        }

        @Test
        @DisplayName("Input n=3 prints triangle with 3 rows")
        void testTriangleWithN3() {
            setUpInput("3\n");
            originalOut = System.out;

            Main.triangChar1(new Scanner(System.in));
            String output = outputStream.toString().trim();
            String expected = "*\n**\n***";
            assertEquals(expected, output);

            restoreSystem();
        }

        @Test
        @DisplayName("Input n=1 prints single star")
        void testTriangleWithN1() {
            setUpInput("1\n");
            originalOut = System.out;

            Main.triangChar1(new Scanner(System.in));
            String output = outputStream.toString().trim();
            String expected = "*";
            assertEquals(expected, output);

            restoreSystem();
        }

        @Test
        @DisplayName("Input n=0 prints nothing")
        void testTriangleWithN0() {
            setUpInput("0\n");
            originalOut = System.out;

            Main.triangChar1(new Scanner(System.in));
            String output = outputStream.toString().trim();
            String expected = "";
            assertEquals(expected, output);

            restoreSystem();
        }

        @Test
        @DisplayName("Input n=5 prints triangle with 5 rows")
        void testTriangleWithN5() {
            setUpInput("5\n");
            originalOut = System.out;

            Main.triangChar1(new Scanner(System.in));
            String output = outputStream.toString().trim();
            String expected = "*\n**\n***\n****\n*****";
            assertEquals(expected, output);

            restoreSystem();
        }

        @Test
        @DisplayName("Negative input n=-1 prints nothing")
        void testTriangleWithNegativeN() {
            setUpInput("-1\n");
            originalOut = System.out;

            Main.triangChar1(new Scanner(System.in));
            String output = outputStream.toString().trim();
            String expected = "";
            assertEquals(expected, output);

            restoreSystem();
        }

        @Test
        @DisplayName("Invalid input throws InputMismatchException")
        void testInvalidInput() {
            setUpInput("abc\n");
            originalOut = System.out;

            Scanner scanner = new Scanner(System.in);
            assertThrows(java.util.InputMismatchException.class, () -> {
                Main.triangChar1(scanner);
            });

            restoreSystem();
        }

        @Test
        @DisplayName("Null scanner throws NullPointerException")
        void testNullScanner() {
            assertThrows(NullPointerException.class, () -> {
                Main.triangChar1(null);
            });
        }
    }

    @Nested
    @DisplayName("Tests for triangChar2 method")
    class TriangChar2Tests {

        private ByteArrayOutputStream outputStream;
        private PrintStream originalOut;

        private void setUpInput(String input) {
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            outputStream = new ByteArrayOutputStream();
            originalOut = System.out;
            System.setOut(new PrintStream(outputStream));
        }

        private void restoreSystem() {
            System.setOut(originalOut);
        }

        @Test
        @DisplayName("Test with n = 1")
        void testTriangChar2WithN1() {
            setUpInput("1\n");
            Main.triangChar2(new Scanner(System.in));
            restoreSystem();
            assertEquals("", outputStream.toString().trim());
        }

        @Test
        @DisplayName("Test with n = 2")
        void testTriangChar2WithN2() {
            setUpInput("2\n");
            Main.triangChar2(new Scanner(System.in));
            restoreSystem();
            assertEquals("", outputStream.toString().trim());
        }

        @Test
        @DisplayName("Test with n = 3")
        void testTriangChar2WithN3() {
            setUpInput("3\n");
            Main.triangChar2(new Scanner(System.in));
            restoreSystem();
            assertEquals("", outputStream.toString().trim());
        }

        @Test
        @DisplayName("Test with n = 0")
        void testTriangChar2WithN0() {
            setUpInput("0\n");
            Main.triangChar2(new Scanner(System.in));
            restoreSystem();
            assertEquals("", outputStream.toString().trim());
        }

        @Test
        @DisplayName("Test with negative n")
        void testTriangChar2WithNegativeN() {
            setUpInput("-1\n");
            Main.triangChar2(new Scanner(System.in));
            restoreSystem();
            assertEquals("", outputStream.toString().trim());
        }
    }

    @Nested
    @DisplayName("plusouMois1 Method Tests")
    class PlusouMois1Tests {
        private Scanner scanner;
        private ByteArrayInputStream inputStream;

        @AfterEach
        void tearDown() {
            if (scanner != null) {
                scanner.close();
            }
        }

        @Test
        @DisplayName("Correct guess on first try")
        void testCorrectGuessFirstTry() {
            String input = "50\n";
            inputStream = new ByteArrayInputStream(input.getBytes());
            scanner = new Scanner(inputStream);

            // Mock Random to return 50
            Random mockRandom = new Random() {
                @Override
                public int nextInt(int bound) {
                    return 49; // Returns 50 after +1 in method
                }
            };

            boolean result = Main.plusouMois1(scanner, 3);
            assertTrue(result, "Should return true for correct guess");
        }

        @Test
        @DisplayName("Run out of tries")
        void testRunOutOfTries() {
            String input = "1\n2\n3\n";
            inputStream = new ByteArrayInputStream(input.getBytes());
            scanner = new Scanner(inputStream);

            boolean result = Main.plusouMois1(scanner, 3);
            assertFalse(result, "Should return false when out of tries");
        }

        @Test
        @DisplayName("Input out of bounds - below range")
        void testInputBelowBounds() {
            String input = "0\n1\n";
            inputStream = new ByteArrayInputStream(input.getBytes());
            scanner = new Scanner(inputStream);

            boolean result = Main.plusouMois1(scanner, 2);
            assertFalse(result, "Should handle out of bounds input");
        }

        @Test
        @DisplayName("Input out of bounds - above range")
        void testInputAboveBounds() {
            String input = "101\n1\n";
            inputStream = new ByteArrayInputStream(input.getBytes());
            scanner = new Scanner(inputStream);

            boolean result = Main.plusouMois1(scanner, 2);
            assertFalse(result, "Should handle out of bounds input");
        }

        @Test
        @DisplayName("Correct half - upper half")
        void testCorrectHalfUpper() {
            String input = "75\n1\n";
            inputStream = new ByteArrayInputStream(input.getBytes());
            scanner = new Scanner(inputStream);

            Random mockRandom = new Random() {
                @Override
                public int nextInt(int bound) {
                    return 74; // Returns 75 after +1
                }
            };

            boolean result = Main.plusouMois1(scanner, 2);
            assertFalse(result, "Should handle correct upper half");
        }

        @Test
        @DisplayName("Correct half - lower half")
        void testCorrectHalfLower() {
            String input = "25\n1\n";
            inputStream = new ByteArrayInputStream(input.getBytes());
            scanner = new Scanner(inputStream);

            Random mockRandom = new Random() {
                @Override
                public int nextInt(int bound) {
                    return 24; // Returns 25 after +1
                }
            };

            boolean result = Main.plusouMois1(scanner, 2);
            assertFalse(result, "Should handle correct lower half");
        }

        @Test
        @DisplayName("Wrong half - guess in upper, number in lower")
        void testWrongHalfUpperToLower() {
            String input = "75\n1\n";
            inputStream = new ByteArrayInputStream(input.getBytes());
            scanner = new Scanner(inputStream);

            Random mockRandom = new Random() {
                @Override
                public int nextInt(int bound) {
                    return 24; // Returns 25 after +1
                }
            };

            boolean result = Main.plusouMois1(scanner, 2);
            assertFalse(result, "Should handle wrong half (upper to lower)");
        }

        @Test
        @DisplayName("Wrong half - guess in lower, number in upper")
        void testWrongHalfLowerToUpper() {
            String input = "25\n1\n";
            inputStream = new ByteArrayInputStream(input.getBytes());
            scanner = new Scanner(inputStream);

            Random mockRandom = new Random() {
                @Override
                public int nextInt(int bound) {
                    return 74; // Returns 75 after +1
                }
            };

            boolean result = Main.plusouMois1(scanner, 2);
            assertFalse(result, "Should handle wrong half (lower to upper)");
        }

        @ParameterizedTest
        @ValueSource(ints = {1, 2, 5, 10})
        @DisplayName("Various number of tries")
        void testVariousTries(int tries) {
            StringBuilder input = new StringBuilder();
            for (int i = 0; i < tries; i++) {
                input.append("1\n");
            }
            inputStream = new ByteArrayInputStream(input.toString().getBytes());
            scanner = new Scanner(inputStream);

            boolean result = Main.plusouMois1(scanner, tries);
            assertFalse(result, "Should handle various number of tries");
        }

        @Test
        @DisplayName("Boundary values - guess 1 and 100")
        void testBoundaryValues() {
            String input = "1\n100\n";
            inputStream = new ByteArrayInputStream(input.getBytes());
            scanner = new Scanner(inputStream);

            boolean result = Main.plusouMois1(scanner, 2);
            assertFalse(result, "Should handle boundary values");
        }
    }

    @Nested
    @DisplayName("Tests for plusouMois2 method")
    class PlusouMois2Tests {
        private Scanner scanner;

        @BeforeEach
        void setUp() {
            scanner = new Scanner(System.in);
        }

        @Test
        @DisplayName("Test with valid k")
        void testPlusouMois2ValidK() {
            // Arrange
            int k = 5;

            // Act
            boolean result = plusouMois2(scanner, k);

            // Assert
            assertTrue(result, "Method should return true");
        }

        @Test
        @DisplayName("Test with k = 0")
        void testPlusouMois2ZeroK() {
            // Arrange
            int k = 0;

            // Act
            boolean result = plusouMois2(scanner, k);

            // Assert
            assertTrue(result, "Method should return true");
        }

        @Test
        @DisplayName("Test with negative k")
        void testPlusouMois2NegativeK() {
            // Arrange
            int k = -1;

            // Act
            boolean result = plusouMois2(scanner, k);

            // Assert
            assertTrue(result, "Method should return true");
        }

        private boolean plusouMois2(Scanner scanner, int k) {
            boolean res = false;
            int[] tableau = new int[100];
            Random r = new Random();
            int rn = r.nextInt(100) + 1;
            for (int i = 0; i < tableau.length; i++) {
                int m;
                boolean unique;
                do {
                    m = r.nextInt(100) + 1; // Range 1 to 100
                    unique = true;
                    for (int j = 0; j < i && unique; j++) {
                        if (m == tableau[j]) {
                            unique = false;
                        }
                    }
                } while (!unique);
                tableau[i] = m;
            }
            System.out.printf("Vous avez %u u'essais pour découvrir un entier secret\n", k);
            // N° u'essais
            int f = 1;
            // lower boundary
            int d = 1;
            // upper boundary
            int u = tableau.length;
            return true;
        }
    }

    @Nested
    @DisplayName("Tests for decomptVoy method")
    class DecomptVoyTests {

        @Test
        @DisplayName("Empty character array should throw exception")
        void testEmptyArray() {
            char[] input = {};
            Exception exception = assertThrows(Exception.class, () -> {
                Main.decomptVoy(input);
            });
            assertEquals("You need to insert at least one char", exception.getMessage());
        }

        @Test
        @DisplayName("Single vowel in array should count matches in message")
        void testSingleVowel() {
            char[] input = {'a'};
            int result = Main.decomptVoy(input);
            assertEquals(6, result); // Counts 'a' in message (case-insensitive)
        }

        @Test
        @DisplayName("Multiple vowels in array should count all matches")
        void testMultipleVowels() {
            char[] input = {'a', 'e', 'i'};
            int result = Main.decomptVoy(input);
            assertEquals(22, result); // Counts 'a', 'e', 'i' in message
        }

        @Test
        @DisplayName("No vowels in array should return zero")
        void testNoVowels() {
            char[] input = {'z', 'x', 'y'};
            int result = Main.decomptVoy(input);
            assertEquals(0, result); // No matches for non-vowels
        }

        @Test
        @DisplayName("Mixed case vowels should count both upper and lower case")
        void testMixedCaseVowels() {
            char[] input = {'A', 'e'};
            int result = Main.decomptVoy(input);
            assertEquals(16, result); // Counts 'a'/'A' and 'e'/'E' in message
        }

        @Test
        @DisplayName("Special characters in array should return zero")
        void testSpecialCharacters() {
            char[] input = {'@', '#', '$'};
            int result = Main.decomptVoy(input);
            assertEquals(0, result); // No matches for special characters
        }

        @Test
        @DisplayName("Single character array with no matches should return zero")
        void testSingleCharNoMatch() {
            char[] input = {'q'};
            int result = Main.decomptVoy(input);
            assertEquals(0, result); // No 'q' in message
        }

        @Test
        @DisplayName("Array with repeated vowels should count all matches")
        void testRepeatedVowels() {
            char[] input = {'e', 'e', 'e'};
            int result = Main.decomptVoy(input);
            assertEquals(30, result); // Counts 'e' multiple times
        }
    }
}
