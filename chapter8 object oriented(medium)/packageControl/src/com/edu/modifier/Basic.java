package com.edu.modifier;

public class Basic {

    public int m1 = 1;
    protected int m2 = 2;
    int m3 = 3;
    private int m4 = 4;


    public void n1() {
        // same class could access all.
        System.out.println("m1=" + m1 + " m2=" + m2 + " m3=" + m3 + " m4=" + m4);
    }

    public static void main(String[] args) {
        Basic basic1 = new Basic();
        basic1.n1();
    }
}
