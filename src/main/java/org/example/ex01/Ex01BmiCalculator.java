package org.example.ex01;

public class Ex01BmiCalculator {
    public static double calculateBmi(double weight, double height) {
        if (weight <= 0 || height <= 0) {
            throw new IllegalArgumentException("Weight and height must be positive numbers");
        }
        double bmi = weight / (height * height);
        return Math.round(bmi * 100) / 100.0;
    }
}
