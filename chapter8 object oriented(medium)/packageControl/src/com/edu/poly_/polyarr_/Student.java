package com.edu.poly_.polyarr_;

public class Student extends Person {
    private double score;

    public Student(String name, int age, double score) {
        super(name, age);
        this.score = score;
    }

    @Override
    public String say() {
        return super.say() + "score = " + score;
    }

    public void study() {
        System.out.println("student " + getName() + " is studying");
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
