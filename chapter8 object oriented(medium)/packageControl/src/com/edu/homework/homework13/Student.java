package com.edu.homework.homework13;

public class Student extends Person {
    private int stu_id;

    public Student(String name, String gender, int age, int stu_id) {
        super(name, gender, age);
        this.stu_id = stu_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public void study(){
        System.out.println("study");
    }

    @Override
    public String play() {
        return super.play() + " " + "basketball";
    }
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("stu_id:"+stu_id);
        this.study();
        System.out.println(this.play());
    }

    @Override
    public String toString() {

        return "student "+ super.toString();
    }
}
