package com.edu.poly_.polyparameter_;
/*
    manager has `bonus` property and `manage` method.
 */
public class Manager extends Employee{

    private double bonus;


    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public void manage() {
        System.out.println(this.getName()+" is managing!");
    }
    @Override
    public double getAnnual() {
        return super.getAnnual() + this.bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
