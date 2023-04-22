package org.example.ex01;

import org.example.ex01.Ex01BmiCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Ex01BmiCalculatorTest {
    @Test
    void shouldCalculateBmi() {
        double weight = 70.0;
        double height = 1.75;
        double expectedBmi = 22.86;

        double actualBmi = Ex01BmiCalculator.calculateBmi(weight, height);

        assertEquals(expectedBmi, actualBmi, 0.01);
    }

    @Test
    void shouldThrowExceptionForNotPositiveWeight() {
        double weight = -70.0;
        double height = 1.75;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Ex01BmiCalculator.calculateBmi(weight, height));
        assertEquals("Weight and height must be positive numbers", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForNotPositiveHeight() {
        double weight = 70.0;
        double height = -1.75;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Ex01BmiCalculator.calculateBmi(weight, height));
        assertEquals("Weight and height must be positive numbers", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForWeightEqualZero() {
        double weight = 0;
        double height = 1.75;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Ex01BmiCalculator.calculateBmi(weight, height));
        assertEquals("Weight and height must be positive numbers", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionForHeightEqualZero() {
        double weight = 70.0;
        double height = 0;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> Ex01BmiCalculator.calculateBmi(weight, height));
        assertEquals("Weight and height must be positive numbers", exception.getMessage());
    }

}