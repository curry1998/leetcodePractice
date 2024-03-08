package com.boshrong.leetcode.技巧;

public class 搜索旋转数组排序数组 {
    public static int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        //lr 找分界点
        while(l<r){
            int mid=(l+r+1)/2;
            if(nums[mid]>=nums[0]){
                l=mid;
            }else{
                r=mid-1;
            }
        }

        // 确定target 所在段
        if(target>=nums[0])
            l=0;
        else{
            l=l;
            r=nums.length-1;
        }

        while(l<r){
            int mid=(l+r+1)/2;
            if(target>=nums[mid]){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        if(nums[l]==target){
            return l;
        }
        return -1;
    }
}
