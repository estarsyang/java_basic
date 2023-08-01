package com.edu.homework;

public class Homework6 {
}

class Grand {
    String name;
    private  int age;
    public void g1(){}
}
/*
    carefully access modifier. public, protected, default, private
 */
class Father extends Grand {
    String id;
    private  double score;
    public void f1(){
        // super can access what properties and methods.
//        super.name
//        super.g1();

        // this can access what
//        this.id;this.score;this.f1();this.name;this.g1();
    }




}

class Son extends Father {
    String name;

    public void g1() {}
    private void show(){
        // super can access what properties and methods.
//        super.id;super.f1();super.name;super.g1();

        // this can access what
//        this.name;this.g1();this.show();this.id;this.f1();
    }
}