package com.boshrong.leetcode.排序类似;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 把数组排成最小数jz45 {

    public String minNumber(int[] nums) {
        int lens=nums.length;
        if(lens==0){
            return "";
        }
        ArrayList<Integer > list = new ArrayList<>();
        for(int num: nums){
            list.add(num);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String ab=o1+""+o2;
                String ba=o2+""+o1;
                return ab.compareTo(ba);
            }
        });
        String res="";
        for(int num: list){
            res+=num;
        }
        return res;
    }
}
