package com.boshrong.leetcode.哈希;

import java.util.HashMap;

public class twoNumSum {
    public static void main(String[] args) {

    }

}
class Solution10 {
    public int[] twoSum(int[] nums, int target) {
        //key存值,value 存位置 collection集合
        HashMap<Integer, Integer> hashmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hashmap.containsKey(target-nums[i])){
                return hashmap.get(target-nums[i])< i ? new int[]{hashmap.get(target-nums[i]),i} :new int[]{i,hashmap.get(target-nums[i])};
            }
            hashmap.put(nums[i],i);
        }
        return new int[0];
    }
}


