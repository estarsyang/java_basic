package com.edu.encap;

public class Encapsulation01 {
    /*
        A person has name, age and salary, All properties will be reasonable, otherwise give default value
        1. age: 1 - 120; default: 18;
        2. name: 2 - 6; default: anonymous.
        3. salary: can't directly access.
     */
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("tom");
        person1.setAge(10);
        person1.setSalary(1000);
        System.out.println(person1.info());


        Person tom = new Person("tom", 10, 1000);
        System.out.println(tom.info());

    }
}

class Person {
    public String name;
    private int age;
    private double salary;

    public Person() {
    }

    public Person(String name, int age, double salary) {
        setName(name);
        setAge(age);
        setSalary(salary);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("length of name must be 2 - 6. default name 'anonymous' is assigned ");
            this.name = "anonymous";
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age<=120){
            this.age = age;
        } else {
            System.out.println("age must be 1 - 120. default age 18 is assigned ");
            this.age =18;
        }
    }

    public double getSalary() {
        // author control.
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String info() {
        return "the info of person is name=" + name  + " age=" + age + " salary=" + salary;
    }
}
