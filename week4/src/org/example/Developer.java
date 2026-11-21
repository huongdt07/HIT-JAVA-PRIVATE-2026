package org.example;


public class Developer extends Employee {
    private int overtimeHours;

    public Developer(String id, String name, double baseSalary, int overtimeHours) {
        super(id, name, baseSalary);
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double getMonthlyIncome() {
        return getBaseSalary() + overtimeHours * 200000;
    }
}
