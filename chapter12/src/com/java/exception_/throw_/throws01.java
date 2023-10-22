package com.java.exception_.throw_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class throws01 {
    public static void main(String[] args) {

    }

    public void f2() throws FileNotFoundException {
        FileInputStream fis = new FileInputStream("aa.txt");
    }
}
