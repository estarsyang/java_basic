package com.edu.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CollectionIterator_ {
    public static void main(String[] args) {
        List col = new ArrayList();

        col.add("tom");
        col.add("jerry");

        Iterator iterator = col.iterator();

        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println(next);
        }

    }
}
