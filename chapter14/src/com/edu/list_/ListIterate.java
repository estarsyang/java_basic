package com.edu.list_;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListIterate {
    public static void main(String[] args) {
        List arrayList = new ArrayList();
        arrayList.add("tom");
        arrayList.add("jerry");
        arrayList.add("mary");

        // enhance for
        for (Object item:arrayList){
            System.out.println(item);
        }

        // for
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}
