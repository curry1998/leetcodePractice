package com.boshrong.leetcode.双指针;

public class 盛最多的水11 {

    public int maxArea(int[] height) {
        int lens=height.length;
        if(lens<2){
            return 0;
        }
        int left=0,right=lens-1;
        int result=Integer.MIN_VALUE;
        while(left<right){
            int tag=right-left;
            if(tag*Math.min(height[left],height[right])>result){
                result=tag*Math.min(height[left],height[right]);
            }
            if(height[left]<=height[right]){
                left++;
            }else{
                right--;
            }
        }
        return result;
    }
}
