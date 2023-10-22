package com.java.exception_.try_;

public class exception_try_finally {
    public static void main(String[] args) {
        int n1=10;
        int n2=0;
        try {
            System.out.println(n1/n2);
        } finally {
            System.out.println("keep running");
        }
        System.out.println("system running");
    }
}
