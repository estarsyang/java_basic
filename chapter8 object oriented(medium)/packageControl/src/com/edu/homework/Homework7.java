package com.edu.homework;

public class Homework7 {
}
class Test {
    String name ="rose";

    public Test() {
        System.out.println("Test");
    }

    public Test(String name) {
        this.name = name;
    }
}

class Demo extends Test{
    String name="jack";

    public Demo() {
        super();
        System.out.println("Demo");
    }

    Demo(String s){
        super(s);
    }

    public void test(){
        System.out.println(super.name);
        System.out.println(this.name);
    }

    public static void main(String[] args) {
        new Demo().test(); // Test Demo rose jack
        new Demo("John").test(); // John, jack
    }
}
