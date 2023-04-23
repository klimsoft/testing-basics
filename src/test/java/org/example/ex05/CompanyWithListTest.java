package org.example.ex05;

import org.example.ex04.CompanyWithList;
import org.example.ex04.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO AssertJ
public class CompanyWithListTest {

    private CompanyWithList company;
    private Employee employee1;
    private Employee employee2;
    private Employee employee3;

    @BeforeEach
    public void setUp() {
        company = new CompanyWithList();
        employee1 = new Employee("John Smith");
        employee2 = new Employee("Anna Doe");
        employee3 = new Employee("Bob Johnson");
    }

    @Test
    @DisplayName("Test addEmployee method")
    public void testAddEmployee() {
        company.addEmployee(employee1);
        company.addEmployee(employee2);

        List<Employee> expectedEmployees = new ArrayList<>();

        expectedEmployees.add(employee1);
        expectedEmployees.add(employee2);
        assertEquals(expectedEmployees, company.getEmployees());
    }

    @Test
    @DisplayName("Test removeEmployee method")
    public void testRemoveEmployee() {
        company.addEmployee(employee1);
        company.addEmployee(employee2);

        company.removeEmployee(employee1);

        List<Employee> expectedEmployees = new ArrayList<>();
        expectedEmployees.add(employee2);
        assertEquals(expectedEmployees, company.getEmployees());
    }

    @Test
    @DisplayName("Test getEmployees method")
    public void testGetEmployees() {
        company.addEmployee(employee1);
        company.addEmployee(employee2);
        company.addEmployee(employee3);

        List<Employee> result = company.getEmployees();

        List<Employee> expectedEmployees = new ArrayList<>();
        expectedEmployees.add(employee1);
        expectedEmployees.add(employee2);
        expectedEmployees.add(employee3);
        assertEquals(expectedEmployees, result);
    }

    @Test
    @DisplayName("Test removeEmployee method with non-existent employee")
    public void testRemoveNonExistentEmployee() {
        company.addEmployee(employee1);

        company.removeEmployee(employee2);

        List<Employee> expectedEmployees = new ArrayList<>();
        expectedEmployees.add(employee1);
        assertEquals(expectedEmployees, company.getEmployees());
    }

    @Test
    @DisplayName("Test getEmployees method with no employees")
    public void testGetEmptyEmployees() {
        List<Employee> expectedEmployees = new ArrayList<>();
        
        assertEquals(expectedEmployees, company.getEmployees());
    }
}
