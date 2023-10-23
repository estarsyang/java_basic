package com.edu.set_;

import java.util.HashSet;
import java.util.Iterator;

public class SetMethod01 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add("tom");
        hashSet.add("jerry");
        hashSet.add("mary");
        hashSet.add("jack");
        hashSet.add("lucy");

        System.out.println(hashSet);

        // iterator
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //enhance for
        for (Object item:hashSet){
            System.out.println(item);
        }
    }
}
