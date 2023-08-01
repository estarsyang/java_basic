package com.edu.homework.homework5;

public class Worker extends Employee {
    public Worker(String name, double salary) {
        super(name, salary);
    }

    @Override
    public void printYearSal() {
        System.out.println("worker");
        super.printYearSal();
    }
}
