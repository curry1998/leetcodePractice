package com.boshrong.leetcode.哈希;

import java.util.HashMap;

public class 四数相加二 {
     // 使用哈希的思想，将两个数组分成两个部分。
     // hashmap 中存储和和 以及这个和出现的次数。
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        // 只需要一个hashmap 即可
        HashMap<Integer,Integer> map = new HashMap<>();
        int res =0;
        for(int a: nums1){
            for(int b : nums2){
                if(!map.containsKey(a+b)){
                    map.put(a+b,1);
                }else{
                    map.put(a+b,map.get(a+b)+1);
                }
            }
        }
        for(int a : nums3){
            for(int b : nums4){
                if(map.containsKey(0-(a+b))){
                    res += map.get(0-(a+b));
                }
            }
        }
        return res;
    }
}
