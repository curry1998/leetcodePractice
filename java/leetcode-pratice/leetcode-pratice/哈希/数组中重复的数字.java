package com.boshrong.leetcode.哈希;

import java.util.HashMap;

public class 数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        int lens=nums.length;
        if(lens<2){
            return 0;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<lens;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                return nums[i];
            }
        }
     return 0;
    }
}
