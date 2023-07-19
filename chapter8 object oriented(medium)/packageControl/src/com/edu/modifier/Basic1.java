package com.edu.modifier;

public class Basic1 {
    public void samePack(){
        Basic basic = new Basic();
        // same package only can public, protected, default
        System.out.print(basic.m1);
        System.out.print(basic.m2);
        System.out.print(basic.m3);
    }

    public void defaultClassTest(){
        // default modifies class -->> same package
        DefaultClass defaultClass = new DefaultClass(); // ok

    }

    public static void main(String[] args) {
        Basic1 basic1 = new Basic1();
        basic1.samePack();
    }
}
