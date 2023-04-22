package org.example;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class Ex01BmiCalculatorAssertJTest {
    @Test
    void shouldCalculateBmi() {
        double weight = 70.0;
        double height = 1.75;
        double expectedBmi = 22.86;

        double actualBmi = Ex01BmiCalculator.calculateBmi(weight, height);

        assertThat(actualBmi).isEqualTo(expectedBmi, Offset.offset(0.01));
    }

    @Test
    void shouldThrowExceptionForNotPositiveWeight() {
        double weight = -70.0;
        double height = 1.75;

        assertThatThrownBy(() -> Ex01BmiCalculator.calculateBmi(weight, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Weight and height must be positive numbers");
    }

    @Test
    void shouldThrowExceptionForNotPositiveHeight() {
        double weight = 70.0;
        double height = -1.75;

        assertThatThrownBy(() -> Ex01BmiCalculator.calculateBmi(weight, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Weight and height must be positive numbers");
    }

    @Test
    void shouldThrowExceptionForWeightEqualZero() {
        double weight = 0;
        double height = 1.75;

        assertThatThrownBy(() -> Ex01BmiCalculator.calculateBmi(weight, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Weight and height must be positive numbers");
    }

    @Test
    void shouldThrowExceptionForHeightEqualZero() {
        double weight = 70.0;
        double height = 0;

        assertThatThrownBy(() -> Ex01BmiCalculator.calculateBmi(weight, height))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Weight and height must be positive numbers");
    }

}