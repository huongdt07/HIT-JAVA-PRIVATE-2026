package org.example;

public class SalesEmployee extends Employee {
    private double sales;

    public SalesEmployee(String id, String name, double baseSalary, double sales) {
        super(id, name, baseSalary);
        this.sales = sales;
    }

    @Override
    public double getMonthlyIncome() {
        return getBaseSalary() + sales * 0.05;
    }
}

