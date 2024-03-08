package com.boshrong.leetcode.基础;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class string按字典序排序 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("ab");
        list.add("abc");
        list.add("bbb");
        list.add("bcdf");
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
        //倒序排列
        Collections.reverse(list);
        System.out.println("--------queue---------");
        queueTest();
    }

    public static void queueTest(){
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        queue.add("a");
        queue.add("ab");
        queue.add("abc");
        queue.add("bbb");
        queue.add("bcdf");
        while(!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
