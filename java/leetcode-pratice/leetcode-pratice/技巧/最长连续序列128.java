package com.boshrong.leetcode.技巧;

import java.util.HashSet;

public class 最长连续序列128 {
    public int longestConsecutive(int[] nums) {
        // 注意重复也算连续
        int lens=nums.length;
        HashSet<Integer> hashSet=new HashSet<>();
        for(int num:nums){
            hashSet.add(num);
        }
        int res=0;
        for(int i=0;i<lens;i++){
            if(hashSet.contains(nums[i]-1)){
                res++;
                continue;
            }
            // 前面没有
            int count=0;
            while(hashSet.contains(nums[i]+1)){
                count++;
                if(count>res){
                    res=count;
                }
            }

        }
        return res;
    }
}
