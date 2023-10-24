package com.edu.map_;

import java.util.HashMap;

public class Map_ {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("no1","tom");
        hashMap.put("no2","jerry");
        System.out.println(hashMap);
        hashMap.put("no1","mary");

        System.out.println(hashMap);
        System.out.println(hashMap.get("no2"));

    }
}
