package com.java.exception_.customexception_;

public class CustomException {
    public static void main(String[] args) {
        int age = 80;
        if (!(age >= 18 && age <= 120)) {
            throw new AgeException("age should be 18 ~ 120");
        }
        System.out.println("age is ok");
    }

}

class AgeException extends RuntimeException {
    public AgeException(String message) {
        super(message);
    }
}
