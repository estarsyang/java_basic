package com.edu.collection_;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CollectionFor {
    public static void main(String[] args) {
        List col = new ArrayList();

        col.add("tom");
        col.add("jerry");

        for (Object item:col){
            System.out.println(item);
        }
    }
}
