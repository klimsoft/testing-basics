package org.example.ex04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void testGetName() {
        Employee employee = new Employee("John");
        Assertions.assertEquals("John", employee.getName());
    }

    @Test
    public void testEquals() {
        Employee employee1 = new Employee("John");
        Employee employee2 = new Employee("John");
        Employee employee3 = new Employee("Jane");

        Assertions.assertEquals(employee1, employee2);
        Assertions.assertNotEquals(employee1, employee3);
    }

    @Test
    public void testHashCode() {
        Employee employee1 = new Employee("John");
        Employee employee2 = new Employee("John");
        Employee employee3 = new Employee("Jane");

        Assertions.assertEquals(employee1.hashCode(), employee2.hashCode());
        Assertions.assertNotEquals(employee1.hashCode(), employee3.hashCode());
    }

    @Test
    public void testToString() {
        Employee employee = new Employee("John");
        Assertions.assertEquals("Employee{name='John'}", employee.toString());
    }
}
