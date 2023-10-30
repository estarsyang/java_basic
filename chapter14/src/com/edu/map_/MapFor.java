package com.edu.map_;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapFor {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();

        hashMap.put("tom", "jerry");
        hashMap.put("job", "marry");
        hashMap.put("jack", "rose");

        // 1. using keySet
        Set keyset = hashMap.keySet();
        for (Object key : keyset) {
            System.out.println(key + "-" + hashMap.get(key));
        }

        // 2.get all values
        Collection values = hashMap.values();
        for (Object value : values) {
            System.out.println(value);
        }

        // 3. entrySet
        Set entrySet = hashMap.entrySet();
        for (Object entry : entrySet) {
            // entry to Map.Entry
            Map.Entry m = (Map.Entry) entry;
            System.out.println(m.getKey() + "-" + m.getValue());
        }
    }
}
