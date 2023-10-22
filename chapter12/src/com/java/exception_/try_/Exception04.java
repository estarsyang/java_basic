package com.java.exception_.try_;

import java.util.Scanner;

/**
 * request input a number, if it could be converted to a number,
 * print the num. if not, still request input a number
 */

public class Exception04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num=0;
        String input = "";

        while (true){
            System.out.println("请输入一个整数:");
            input = scanner.next();
            try {
                num=Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的不是整数");
            }
        }
        System.out.println("你输入的整数是"+num);
    }
}
