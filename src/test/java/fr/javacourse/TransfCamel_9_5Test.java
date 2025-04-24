package fr.javacourse;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TransfCamel_9_5Test {

    @Test
    void testEmptyString() {
        assertEquals("", TransfCamel_9_5.transfCamel(""));
    }

    @Test
    void testSingleLetter() {
        assertEquals("a", TransfCamel_9_5.transfCamel("a"));
        assertEquals("z", TransfCamel_9_5.transfCamel("Z"));
    }

    @Test
    void testSingleWord() {
        assertEquals("hello", TransfCamel_9_5.transfCamel("hello"));
        assertEquals("hello", TransfCamel_9_5.transfCamel("HELLO"));
        assertEquals("hello", TransfCamel_9_5.transfCamel("Hello"));
    }

    @Test
    void testMultipleWordsWithSpaces() {
        assertEquals("helloWorld", TransfCamel_9_5.transfCamel("hello world"));
        assertEquals("thisIsTest", TransfCamel_9_5.transfCamel("this is test"));
        assertEquals("camelCaseExample", TransfCamel_9_5.transfCamel("camel case example"));
    }

    @Test
    void testWordsWithPunctuation() {
        assertEquals("helloWorld", TransfCamel_9_5.transfCamel("hello,world"));
        assertEquals("thisIsTest", TransfCamel_9_5.transfCamel("this.is;test"));
        assertEquals("camelCaseExample", TransfCamel_9_5.transfCamel("camel-case,example"));
    }

    @Test
    void testMixedCaseAndPunctuation() {
        assertEquals("helloWorldTest", TransfCamel_9_5.transfCamel("HELLO world,TEST"));
        assertEquals("camelCaseExample", TransfCamel_9_5.transfCamel("CaMeL cAsE,ExAmPlE"));
    }

    @Test
    void testNumbers() {
        assertEquals("hello123world", TransfCamel_9_5.transfCamel("hello 123 world"));
        assertEquals("test42example", TransfCamel_9_5.transfCamel("test 42 example"));
    }

    @Test
    void testLeadingNonLetter() {
        assertEquals("", TransfCamel_9_5.transfCamel("123hello"));
        assertEquals("", TransfCamel_9_5.transfCamel("!hello"));
        assertEquals("", TransfCamel_9_5.transfCamel(" hello"));
    }

    @Test
    void testOnlyNonLetters() {
        assertEquals("", TransfCamel_9_5.transfCamel("123"));
        assertEquals("", TransfCamel_9_5.transfCamel("!@#$%"));
        assertEquals("", TransfCamel_9_5.transfCamel("   "));
    }

    @Test
    void testComplexInput() {
        assertEquals("hello123WorldTest", TransfCamel_9_5.transfCamel("hello 123 world,test"));
        assertEquals("thisIs42TestCase", TransfCamel_9_5.transfCamel("this is 42 test-case"));
    }

    @Test
    void testUnicodeLetters() {
        assertEquals("hélloWörld", TransfCamel_9_5.transfCamel("héllo wörld"));
        assertEquals(" naïveTest", TransfCamel_9_5.transfCamel(" naïve test"));
    }

    @Test
    void testConsecutiveSeparators() {
        assertEquals("helloWorld", TransfCamel_9_5.transfCamel("hello   world"));
        assertEquals("testCase", TransfCamel_9_5.transfCamel("test,,,case"));
        assertEquals("aB", TransfCamel_9_5.transfCamel("a!!!b"));
    }

    @Test
    void testTrailingSeparators() {
        assertEquals("hello", TransfCamel_9_5.transfCamel("hello  "));
        assertEquals("test", TransfCamel_9_5.transfCamel("test,,"));
    }

    @Test
    void testLeadingSeparatorsWithValidStart() {
        assertEquals("helloWorld", TransfCamel_9_5.transfCamel("  hello world"));
        assertEquals("testCase", TransfCamel_9_5.transfCamel(",,test case"));
    }
}