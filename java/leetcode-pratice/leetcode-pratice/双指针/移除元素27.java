package com.boshrong.leetcode.双指针;

public class 移除元素27 {
    public static void main(String[] args) {
        removeElement(new int[]{0,1,2,2,3,0,4,2},2);
    }
    public static  int removeElement(int[] nums, int val) {
        int lens=nums.length;
        if(lens==0){
            return lens;
        }
        int left=0,right=0;
        while(right<lens){
            if(nums[right]==val){
                right++;
            }else{
                nums[left]=nums[right];
                left++;
                right++;
            }
        }
        return left;
    }
}
