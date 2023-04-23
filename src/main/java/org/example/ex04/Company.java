package org.example.ex04;

import java.util.Arrays;

public class Company {
    private Employee[] employees;
    private int numEmployees;

    public Company(int capacity) {
        employees = new Employee[capacity];
        numEmployees = 0;
    }

    public void addEmployee(Employee employee) {
        if (numEmployees < employees.length) {
            employees[numEmployees] = employee;
            numEmployees++;
        } else {
            throw new IllegalStateException("Company is full, cannot add employee.");
        }
    }

    public void removeEmployee(Employee employee) {
        int index = -1;
        for (int i = 0; i < numEmployees; i++) {
            if (employees[i].equals(employee)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Employee not found in company.");
        }
        for (int i = index; i < numEmployees - 1; i++) {
            employees[i] = employees[i + 1];
        }
        employees[numEmployees - 1] = null;
        numEmployees--;
    }

    public Employee[] getEmployees() {
        return Arrays.copyOf(employees, numEmployees);
    }
}

