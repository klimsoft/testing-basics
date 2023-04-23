package org.example.ex02;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator = new Calculator();

    @Test
    @DisplayName("Should add numbers")//you can add display nemes
    public void shouldAddNumbers() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    public void shouldSubtractNumbers() {
        assertEquals(2, calculator.subtract(4, 2));
    }

    @Test
    public void shouldMultiplyNumbers() {
        assertEquals(8, calculator.multiply(4, 2));
    }

    @Test
    public void shouldDivideNumbers() {
        assertEquals(2, calculator.divide(4, 2));
    }

    @Test
    @DisplayName("Should trow exception for divide by zero ")
    public void shouldThrowExceptionIfDivideByZero() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> calculator.divide(4, 0));
        assertEquals("Cannot divide by zero!", exception.getMessage());
    }
}