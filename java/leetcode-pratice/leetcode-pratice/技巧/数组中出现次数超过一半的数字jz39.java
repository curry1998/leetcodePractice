package com.boshrong.leetcode.技巧;

public class 数组中出现次数超过一半的数字jz39 {
    public int MoreThanHalfNum_Solution(int [] nums) {
        int n = nums.length;
        if(n < 1){
            return -1;
        }
        int count = 1;
        int num = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] != num){
                count--;
                if(count <= 0){
                    num = nums[i];
                    count = 1;
                }
            }else{
                count++;
            }
        }
        return num;
    }
}
