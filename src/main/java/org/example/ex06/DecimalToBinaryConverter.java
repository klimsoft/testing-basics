package org.example.ex06;

public class DecimalToBinaryConverter {

    public static String decimalToBinary(int decimal) {
        if (!isValidDecimal(decimal)) {
            throw new IllegalArgumentException("Decimal number must be a positive integer");
        }
        StringBuilder binary = new StringBuilder();
        while (decimal > 0) {
            binary.append(decimal % 2);
            decimal /= 2;
        }
        return binary.reverse().toString();
    }

    public static boolean isValidDecimal(int decimal) {
        return decimal > 0;
    }

}

