package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("a01", "huong xg", 10000000));
        employees.add(new Developer("a02", "abc", 12000000, 10));
        employees.add(new SalesEmployee("a03", "xyz", 10000000, 5000000));

        for (Employee employee : employees) {
            System.out.println("Ma NV: " + employee.getId());
            System.out.println("Ten NV: " + employee.getName());
            System.out.println("Thu nhap: " + employee.getMonthlyIncome());
            System.out.println("----------------------");
        }
    }
}

