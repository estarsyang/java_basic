package com.edu.homework;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

/**
 * 1. Using HashMap to init a Map object, key stores employee's name, value stores employee's salary.
 * 2. jack-650, tom-1200,smith-2900
 * 3. Salary of jack from 650 to 2600
 * 4. Add 100 to all the employee's salary
 * 5. Iterate all employee
 * 6. Iterate all employee's salary
 */
public class Homework03 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put("jack",650);
        hashMap.put("tom",1200);
        hashMap.put("smith",2900);

        hashMap.put("jack",2600);

        // add 100
        Set set = hashMap.keySet();
        for (Object key:set){
            hashMap.put(key,(Integer) hashMap.get(key) + 100);
        }

        System.out.println(hashMap);

        // iterate all employee
        for (Object key:set){
            System.out.println(key + "-" + hashMap.get(key));
        }

        // iterate all values
        Collection values = hashMap.values();
        for (Object value: values){
            System.out.println(value);
        }


    }
}
