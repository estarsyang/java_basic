package com.edu.homework;

/*
    Person class, Student extends Person class and override run method. Please write down the methods for upcasting
    and downcasting, and then, what's the output when the method is called.
 */
public class Homework11 {
    public static void main(String[] args) {
        Person p = new Student();
        // which method p can be called.
        p.run(); // student run
        p.eat(); // person eat

        Student student = (Student) p;
        student.run(); // student run
        student.eat(); // person eat
        student.study();// student study
    }
}

class Person {
    public void run() {
        System.out.println("person run");
    }

    public void eat() {
        System.out.println("person eat");
    }
}

class Student extends Person {
    @Override
    public void run() {
        System.out.println("Student run");
    }

    public void study(){
        System.out.println("Student study");
    }
}