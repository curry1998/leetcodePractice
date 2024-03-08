package com.boshrong.leetcode.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最接近的三数之和16 {
    public static void main(String[] args){
        int [] nums={0,1,2};
        System.out.println(threeSumClosest(nums,3));
    }
    public static  int threeSumClosest(int[] nums, int target) {
        int lens=nums.length;

        if(lens<3) {
            return 0;
        }
        Arrays.sort(nums);
        int result=Integer.MIN_VALUE;
        int min_tag=Integer.MAX_VALUE;
        for(int i=0;i<lens-1;i++){
            int left=i+1;
            int right=lens-1;
            while(left<right){
                if(Math.abs((nums[i]+nums[left]+nums[right])-target)<min_tag){
                    min_tag=Math.abs((nums[i]+nums[left]+nums[right])-target);
                    result=nums[i]+nums[left]+nums[right];
                }

                if(nums[i]+nums[left]+nums[right]-target>=0){
                    right--;
                    continue;
                }else if(nums[i]+nums[left]+nums[right]-target<0){
                    left++;
                    continue;
                }
            }
        }
        return result;
    }
}
