package org.example.ex04;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

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
    public void shouldAddEmployees1() {
        company.addEmployee(employee1);
        company.addEmployee(employee2);

        assertEquals(2, company.getEmployees().length);
        assertTrue(Arrays.asList(company.getEmployees()).contains(employee1));
        assertTrue(Arrays.asList(company.getEmployees()).contains(employee2));
    }

    @Test
    @DisplayName("Should add employees")
    public void shouldAddEmployees2() {
        company.addEmployee(employee1);
        company.addEmployee(employee2);
        Employee[] expected = {employee1, employee2};

        assertTrue(Arrays.equals(company.getEmployees(), expected));
    }

    @Test
    @DisplayName("Should add employees")
    public void shouldAddEmployees3() {
        company.addEmployee(employee1);
        company.addEmployee(employee2);
        Employee[] expected = {employee1, employee2};

        Assertions.assertArrayEquals(company.getEmployees(), expected);
    }

    @Test
    @DisplayName("Should remove employee")
    public void shouldRemoveEmployee() {
        company.addEmployee(employee1);
        company.addEmployee(employee2);

        company.removeEmployee(employee1);

        assertEquals(1, company.getEmployees().length);
        assertFalse(Arrays.asList(company.getEmployees()).contains(employee1));
        assertTrue(Arrays.asList(company.getEmployees()).contains(employee2));
    }

    @Test
    @DisplayName("Should get employees")
    public void shouldGetEmployees() {
        company.addEmployee(employee1);
        company.addEmployee(employee2);

        Employee[] result = company.getEmployees();

        assertEquals(2, result.length);
    }

    @Test
    @DisplayName("Test addEmployee throws exception when company is full")
    public void shouldThrowExceptionWhenCompanyIsFull() {
        company.addEmployee(employee1);
        company.addEmployee(employee2);

        assertThrows(IllegalStateException.class, () -> company.addEmployee(new Employee("Jack")));
    }

    @Test
    @DisplayName("Test removeEmployee throws exception when employee not found")
    public void shouldThrowExceptionWhenEmployeeToRemoveNotFound() {
        assertThrows(IllegalArgumentException.class, () -> company.removeEmployee(employee1));
    }

}
