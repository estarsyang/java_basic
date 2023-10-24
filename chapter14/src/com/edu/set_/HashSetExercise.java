package com.edu.set_;

import java.util.HashSet;
import java.util.Objects;

/**
 * 1. a `Employee` class, it have `age`, `name` properties.
 * 2. Create three employee, store in HashSet.
 * 3. When `name` and `age` are equal to exist data, it's the same employee. Can't be inserted into HashSet.
 */
public class HashSetExercise {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee("tom",19));
        hashSet.add(new Employee("jerry",29));
        hashSet.add(new Employee("tom",19));

        System.out.println("hashSet" + hashSet);
    }
}
class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}