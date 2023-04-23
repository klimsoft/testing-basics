package org.example.ex07;

import org.example.ex02.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorParametrisedTest {
    private Calculator calculator = new Calculator();
    @DisplayName("Test add method with multiple parameters")
    @ParameterizedTest(name = "{index} => a={0}, b={1}, sum={2}")
    @CsvSource({
            "1, 2, 3",
            "5, -3, 2",
            "10, 5, 15",
            "-5, -10, -15"
    })
    void testAdd(int a, int b, int sum) {
        assertThat(calculator.add(a, b)).isEqualTo(sum);
    }

    @ParameterizedTest
    @MethodSource("dataForSubtractProvider")
    void testSubtract(int a, int b, int expected) {
        assertThat(calculator.subtract(a, b)).isEqualTo(expected);
    }

    static Stream<Arguments> dataForSubtractProvider() {
        return Stream.of(
                Arguments.of(2, 3, -1),
                Arguments.of(0, 0, 0),
                Arguments.of(-2, 3, -5),
                Arguments.of(100, -50, 150)
        );
    }

}
