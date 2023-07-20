package com.edu.override_;
//  2. Student class, inherit Person class, add private id, score, constructor,
//    say method(return self introduction, String).
public class Student extends Person {
    private int id;
    private double score;

    public Student(String name, int age, int id, double score) {
        super(name, age);
        this.setId(id);
        this.setScore(score);
    }

    public String say() { // directly call super method to contact return
        return super.say() + " id is " + id + " score is " + score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
