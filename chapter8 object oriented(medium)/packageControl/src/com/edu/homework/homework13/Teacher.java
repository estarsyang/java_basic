package com.edu.homework.homework13;

public class Teacher extends Person {
    private int work_age;

    public Teacher(String name, String gender, int age, int work_age) {
        super(name, gender, age);
        this.work_age = work_age;
    }

    public int getWork_age() {
        return work_age;
    }

    public void setWork_age(int work_age) {
        this.work_age = work_age;
    }

    public void teach(){
        System.out.println("teach");
    }

    @Override
    public String play() {
        return super.play() + " " + "football";
    }

    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("work_age:"+work_age);
        this.teach();
        System.out.println(this.play());
    }

    @Override
    public String toString() {

        return "teacher "+ super.toString();
    }

}
