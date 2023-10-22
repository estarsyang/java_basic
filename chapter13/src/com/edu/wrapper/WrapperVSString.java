package com.edu.wrapper;

public class WrapperVSString {
    public static void main(String[] args) {
        // Integer to String
        Integer i = 10;

        // method 1
        String str1 = i + "";

        // method 2
        String str2 = String.valueOf(i);

        // method 3
        String str3 = i.toString();

        // String to Integer
        String str4 = "123";

        // method 1
        Integer num1 = Integer.parseInt(str4);

        // method 2
        Integer num2 = Integer.valueOf(str4);
    }
}
