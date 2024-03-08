package com.boshrong.leetcode.数学;

import java.util.Arrays;

public class 组合的最大值字节 {
    public static void main(String[] args) {

    }
    public  void maxNum(int n,int [] nums){
        int len1=nums.length;
        Arrays.sort(nums);
        // 获取n的size
        int val=n;
        int len2=0;
        while(val !=0){
            val/=10;
            len2++;
        }

    }
}
