package com.edu.override_;
/*
    1. Person class, private name, age. constructor, say method(return self introduction, String)
    2. Student class, inherit Person class, add private id, score, constructor,
    say method(return self introduction, String).
    3. main new Person and new Student, call say methods
 */
public class OverExercise01 {
    public static void main(String[] args) {
        Person jack = new Person("jack", 12);
        System.out.println(jack.say());

        Student tom = new Student("tom", 12, 123, 39);
        System.out.println(tom.say());


    }
}
