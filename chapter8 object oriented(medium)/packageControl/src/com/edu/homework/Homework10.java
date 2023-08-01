package com.edu.homework;

import javax.print.Doc;

/*
    Override equals in Doctor class.
    Doctor
    name,age, and so on...
 */
public class Homework10 {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("tom", 12);
        Doctor doctor1 = new Doctor("tom", 12);
        System.out.println(doctor1.equals(doctor1));
    }
}

class Doctor {
    private String name;
    private int age;

    public Doctor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Doctor)) {
            return false;
        }
        Doctor doctor = (Doctor) obj;
        return this.name.equals(doctor.name) && this.age == doctor.age;
    }
}
