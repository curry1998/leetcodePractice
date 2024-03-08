package com.boshrong.leetcode.排序类似;

import java.util.Arrays;

public class 最大数 {
    public String largestNumber(int[] nums) {
        int n =nums.length;
        if(n==0){
            return null;
        }
        String [] stringNums = new String [n];
        for(int i=0;i<n;i++){
            stringNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(stringNums,(o1,o2)->{
            return (o2+o1).compareTo(o1+o2);
        });
        String res ="";
        for(int i=0;i<n;i++){
            res+=stringNums[i];
        }
        if(res.charAt(0)=='0'){
            return String.valueOf(res.charAt(0));
        }
        return res;
    }
}
