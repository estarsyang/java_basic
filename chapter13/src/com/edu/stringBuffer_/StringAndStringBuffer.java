package com.edu.stringBuffer_;

public class StringAndStringBuffer {
    public static void main(String[] args) {
        // String --> StringBuffer
        // method1 using construct
        // no affect str
        String str = "hello tom";
        StringBuffer stringBuffer = new StringBuffer(str);

        // method2 using append
        StringBuffer stringBuffer1 = new StringBuffer();
        stringBuffer1 = stringBuffer1.append(str);

        // StringBuffer --> String
        // method1 using toString
        StringBuffer stringBuffer3 = new StringBuffer("hello world");
        String s = stringBuffer3.toString();

        // method2 using construct
        String s1 = new String(stringBuffer3);


    }
}
