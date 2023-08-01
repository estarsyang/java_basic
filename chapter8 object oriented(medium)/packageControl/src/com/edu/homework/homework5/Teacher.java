package com.edu.homework.homework5;

public class Teacher extends Employee {
    private int classDay;
    private double classSal;

    public Teacher(String name, double salary) {
        super(name, salary);
    }

    public int getClassDay() {
        return classDay;
    }

    public void setClassDay(int classDay) {
        this.classDay = classDay;
    }

    public double getClassSal() {
        return classSal;
    }

    public void setClassSal(double classSal) {
        this.classSal = classSal;
    }

    @Override
    public void printYearSal() {
        System.out.println("Teacher");
        System.out.println("year salary is " + (getSalary() * getSalaryMonth() + getClassDay() * getClassSal()));
    }
}
