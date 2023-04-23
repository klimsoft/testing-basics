package org.example.ex04;

import java.util.ArrayList;
import java.util.List;

public class CompanyWithList {

    private List<Employee> employees;

    public CompanyWithList() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}

