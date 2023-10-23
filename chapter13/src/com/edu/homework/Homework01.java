package com.edu.homework;

public class Homework01 {
    public static void main(String[] args) {
        String str="hello world";
        System.out.println(reverse(str,1,7));

    }

    public static String reverse(String str, int start, int end){

        if (!(str != null && start >=0&&start<end&&end<str.length())){
            throw new RuntimeException("input params error");
        }

        char[] chars = str.toCharArray();
        char temp =' ';
        for (int i=start,j=end;i<j;i++,j--){
            temp = chars[i];
            chars[i] = chars[j];
            chars[j]=temp;
        }
        return new String(chars);
    }
}
