package com.edu.poly_.polyparameter_;

/*
     1. Definite `Employee`, including `name` and `salary`(private), also including `getAnnual` method.
     Worker and manager inherit `Employee`, manager has `bonus` property and `manage` method. Staff has `work` method.
     Worker and manager need to override `getAnnual` method.
     2. Test class add one methods named `showEmpAnnual(Employee e)` to get one employee's annual salary,
     and call this method in main function.
     3. Test class add one methods name `testWork`, if pass one worker, call `work` method. if pass one manager,
     call `manage` method.
 */
public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getAnnual() {
        return 12 * this.salary;
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
}
