package com.boshrong.leetcode.排序类似;

public class 搜索旋转排序数组33 {
    public static void main(String[] args) {
        search(new int[] {1,3},1);
    }
    public static int search(int[] nums, int target) {
        int lens=nums.length;
        if(lens==0||lens==1 && nums[0]!=target){
            return -1;
        }
        int k=lens-1;
        while(k>0 && nums[0]>nums[k]){
            k--;
        }
        // 确定区间
        int left=0,right=0;
        if(target>nums[lens-1]){
            left=0;
            right=k;
        }else{
            left=k+1;
            right=lens-1;
        }
        // 二分查找
        while(left<=right){
            if(left==right && nums[left]==target){
                return left;
            }else if (left==right && nums[left]!=target){
                return -1;
            }
            int mid=(right+left)/2;
            if(target>nums[mid]){
                left=mid+1;
            }else if(target<nums[mid]){
                right=mid-1;
            }else {
                return mid;
            }
        }
       return -1;
    }
}
