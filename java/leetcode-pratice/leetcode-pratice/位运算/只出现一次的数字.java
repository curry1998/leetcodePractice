package com.boshrong.leetcode.位运算;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int lens=nums.length;
        if(lens==0){
            return -1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(map.containsKey(num)){
                map.replace(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        int result=-1;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()==1){
                result=entry.getKey();
            }
        }
        return result;
    }
}
