package org.example.ex03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringManipulationTest {

    private StringManipulation stringManipulation = new StringManipulation();

    @Test
    public void shouldReverseString() {
        String original = "hello";
        String expected = "olleh";

        StringManipulation stringManipulation = new StringManipulation();
        String actual = stringManipulation.reverseString(original);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRecognisePalindrome() {
        String original = "racecar";
        StringManipulation stringManipulation = new StringManipulation();

        boolean actual = stringManipulation.isPalindrome(original);

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldRecogniseNotPalindrome() {
        String original = "car";
        StringManipulation stringManipulation = new StringManipulation();

        boolean actual = stringManipulation.isPalindrome(original);

        Assertions.assertFalse(actual);
    }

}
