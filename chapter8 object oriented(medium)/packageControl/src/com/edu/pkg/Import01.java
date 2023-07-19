package com.edu.pkg;

import java.util.Arrays;

public class Import01 {
    // using Array class to sort the arr


    public static void main(String[] args) {
        int[] arr = {-1, 4, 10, 2};
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }


}
