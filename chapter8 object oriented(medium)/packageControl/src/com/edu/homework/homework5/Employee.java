package com.edu.homework.homework5;
/*
    Parent class - Employee,
    child class - Worker, Peasant, Teacher, Scientist, Waiter
    1. Worker,Peasant,Waiter has basic salary.
    2. Teacher has salary and class fee( classDay * classSalary)
    3. Scientist has salary and bonus
    4. Write a Test class, print all employee's year salary.
 */
public class Employee {
    private String name;
    private double salary;
    private int salaryMonth = 12;


    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getSalaryMonth() {
        return salaryMonth;
    }

    public void setSalaryMonth(int salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    public void printYearSal(){
        System.out.println("year salary is " + (salary*salaryMonth));
    }
}
