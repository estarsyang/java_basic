package com.edu.wrapper;

public class Interger01 {
    public static void main(String[] args) {
        // before jdk5
        // manual boxing
        int i = 200;
        Integer integer1 = new Integer(i);
        Integer integer2 = Integer.valueOf(i);

        // manual unboxing
        int n1 = integer1.intValue();

        // after jdk5
        // auto boxing
        int n2 =200;
        Integer integer03 = n2; // in the root, it uses Integer.valueOf(n2)
        // auto unboxing
        int n3 = integer03; // in the root, it uses intValue() method

    }
}
