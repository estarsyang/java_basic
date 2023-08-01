package com.edu.homework.homework5;

public class Test {
    public static void main(String[] args) {
        Worker tom = new Worker("tom", 1000);
        tom.setSalaryMonth(10);
        tom.printYearSal();

        Teacher bob = new Teacher("bob", 1000);
        bob.setClassDay(10);
        bob.setClassSal(200);
        bob.printYearSal();

        Scientist mary = new Scientist("mary", 1000);
        mary.setBonus(1000);
        mary.printYearSal();
    }
}
