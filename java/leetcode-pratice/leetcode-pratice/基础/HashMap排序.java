package com.boshrong.leetcode.基础;

import java.util.*;

public class HashMap排序 {
    public static void main(String[] args) {

        // key 是有序的
        SortedMap sortedMap = new TreeMap();

        sortedMap.put("a", "one");
        sortedMap.put("c", "three");
        sortedMap.put("b", "two");


        Iterator iterator = sortedMap.keySet().iterator();

        while(iterator.hasNext()) {
            String key   = (String) iterator.next();
            System.out.println(key);
            String value = (String) sortedMap.get(key);
        }
    }
}
