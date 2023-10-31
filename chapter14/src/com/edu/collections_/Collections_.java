package com.edu.collections_;

import java.util.ArrayList;
import java.util.Collections;

public class Collections_ {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("tom");
        arrayList.add("jerry");
        arrayList.add("jack");

        System.out.println(arrayList);

        // reverse
        Collections.reverse(arrayList);
        System.out.println(arrayList);

        //shuffle
        Collections.shuffle(arrayList);
        System.out.println(arrayList);


    }
}
