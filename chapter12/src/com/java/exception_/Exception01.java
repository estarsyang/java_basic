package com.java.exception_;

public class Exception01 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;

        try {
            int res = num1 / num2; // using try catch
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("keep running");
    }
}
