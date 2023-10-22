package com.java.exception_;

public class Homeworkd03 {
    // B A D
    public static void main(String[] args) {
        try {
            func();
            System.out.println("A");
        } catch (Exception e){
            System.out.println("C");
        }
        System.out.println("D");
    }
    public static void func(){
        try {
            throw new RuntimeException();
        } finally {
            System.out.println("B");
        }
    }
}
