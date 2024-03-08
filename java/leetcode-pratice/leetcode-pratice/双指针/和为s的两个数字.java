package com.boshrong.leetcode.双指针;

public class 和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        int lens=nums.length;
        if(lens<1){
            return new int []{};
        }
        int[] ints = new int[2];
        int left=0,right=lens-1;
        while(left<right){
            if(nums[left]+nums[right]==target){
                ints[0]=nums[left];
                ints[1]=nums[right];
                break;
            }
            if(nums[left]+nums[right]>target){
                right--;
            }else{
                left++;
            }
        }
        return ints;
    }
}
