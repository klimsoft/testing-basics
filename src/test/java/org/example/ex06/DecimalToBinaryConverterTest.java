package org.example.ex06;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DecimalToBinaryConverterTest {

    @Test
    @DisplayName("Valid decimal numbers should return correct binary representation")
    public void testDecimalToBinaryWithValidDecimal() {
        assertThat(DecimalToBinaryConverter.decimalToBinary(10)).isEqualTo("1010");
        assertThat(DecimalToBinaryConverter.decimalToBinary(255)).isEqualTo("11111111");
    }

    @Test
    @DisplayName("Invalid decimal numbers should throw exception")
    public void testDecimalToBinaryWithInvalidDecimal() {
        assertThatIllegalArgumentException().isThrownBy(() -> DecimalToBinaryConverter.decimalToBinary(-1))
                .withMessage("Decimal number must be a positive integer");
    }

    @Test
    @DisplayName("Valid decimal numbers should return true for isValidDecimal")
    public void testIsValidDecimalWithValidDecimal() {
        assertThat(DecimalToBinaryConverter.isValidDecimal(1)).isTrue();
        assertThat(DecimalToBinaryConverter.isValidDecimal(10)).isTrue();
        assertThat(DecimalToBinaryConverter.isValidDecimal(255)).isTrue();
    }

    @Test
    @DisplayName("Invalid decimal numbers should return false for isValidDecimal")
    public void testIsValidDecimalWithInvalidDecimal() {
        assertThat(DecimalToBinaryConverter.isValidDecimal(0)).isFalse();
        assertThat(DecimalToBinaryConverter.isValidDecimal(-1)).isFalse();
        assertThat(DecimalToBinaryConverter.isValidDecimal(-100)).isFalse();
    }
}
