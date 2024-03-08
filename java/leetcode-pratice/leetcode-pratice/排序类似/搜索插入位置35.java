package com.boshrong.leetcode.排序类似;

public class 搜索插入位置35 {
    public static void main(String[] args) {

    }
    public int searchInsert(int[] nums, int target) {
        int len1=nums.length;
        if(len1==0){
            return 0;
        }
        int left=0,right=len1-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target) {
                right=mid-1;
            }else{
                return mid;
            }
        }
        return left;
    }
}
