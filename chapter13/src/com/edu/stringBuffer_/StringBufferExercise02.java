package com.edu.stringBuffer_;

public class StringBufferExercise02 {
    public static void main(String[] args) {
        /**
         * price format:
         * 1000.24 --> 1,000.24
         * 423.24 ---> 423.23
         * 410023.54 ---> 410,023.54
         */

        String price = "123456.78";

        StringBuffer sb = new StringBuffer(price);

        for (int i = sb.indexOf(".") - 3; i > 0 ; i -= 3) {
            sb = sb.insert(i,",");
        }
        System.out.println(sb);
    }
}
