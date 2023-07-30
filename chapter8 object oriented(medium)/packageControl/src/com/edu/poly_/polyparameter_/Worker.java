package com.edu.poly_.polyparameter_;


public class Worker extends Employee{
    public Worker(String name, double salary) {
        super(name, salary);
    }

    public void work() {
        System.out.println(this.getName() + "is work!");
    }
    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
