package com.edu.map_;

import java.util.*;

/**
 * HashMap add three employee, request:
 * 1.key: employee id
 * 2.value: employee object.
 * 3.for: show object what salary > 18000
 * 4. Employee: name, salary, id
 */
public class MapExercise {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put(1,new Employee("jack",30000, 1));
        hashMap.put(2,new Employee("tom",20000, 2));
        hashMap.put(3,new Employee("milan",10000, 3));

        // using keySet
        Set keySet = hashMap.keySet();
        for (Object key:keySet) {
            Employee emp =(Employee) hashMap.get(key);
            if (emp.getSalary() > 18000) {
                System.out.println(emp);
            }
        }

        // using entrySet
        Set entrySet = hashMap.entrySet();
        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry =(Map.Entry)  iterator.next();
            Employee emp =(Employee) entry.getValue();
            if (emp.getSalary() > 18000){
                System.out.println(emp);
            }
        }
    }
}

class Employee {
    private String name;
    private double salary;
    private int id;

    public Employee(String name, double salary, int id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
    }
}
