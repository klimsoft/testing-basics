package org.example.ex01;

import java.util.Scanner;

public class BmiCalculatorRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your weight in kilograms: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter your height in meters: ");
        double height = scanner.nextDouble();

        double bmi = BmiCalculator.calculateBmi(weight, height);
        System.out.printf("Your BMI is %.2f", bmi);
    }
}
