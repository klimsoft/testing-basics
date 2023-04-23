package org.example.ex05;

import org.assertj.core.api.Assertions;
import org.example.ex04.Company;
import org.example.ex04.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CompanyTest {
    private Company company;
    private Employee employee1;
    private Employee employee2;

    @BeforeEach
    public void setUp() {
        company = new Company(2);
        employee1 = new Employee("John");
        employee2 = new Employee("Anna");
    }

    @Test
    @DisplayName("Should add employees")
    public void shouldAddEmployees() {
        company.addEmployee(employee1);
        company.addEmployee(employee2);

        Employee[] employees = company.getEmployees();

        Assertions.assertThat(employees).containsExactly(employee1, employee2);
    }

    @Test
    @DisplayName("Should remove employee")
    public void shouldRemoveEmployee() {
        company.addEmployee(employee1);
        company.addEmployee(employee2);

        company.removeEmployee(employee1);

        Assertions.assertThat(company.getEmployees()).containsExactly(employee2);
    }

    @Test
    @DisplayName("Should get employees")
    public void shouldGetEmployees() {
        company.addEmployee(employee1);
        company.addEmployee(employee2);

        Employee[] result = company.getEmployees();

        Assertions.assertThat(result).containsExactly(employee1, employee2);
    }

    @Test
    @DisplayName("Test addEmployee throws exception when company is full")
    public void shouldThrowExceptionWhenCompanyIsFull() {
        company.addEmployee(employee1);
        company.addEmployee(employee2);

        Assertions.assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> company.addEmployee(new Employee("Jack")))
                .withMessage("Company is full, cannot add employee.");
    }

    @Test
    @DisplayName("Test removeEmployee throws exception when employee not found")
    public void shouldThrowExceptionWhenEmployeeToRemoveNotFound() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> company.removeEmployee(employee1))
                .withMessage("Employee not found in company.");
    }

}
