package com.boshrong.leetcode.双指针;

public class 有序数组的平方 {
    public int[] sortedSquares(int[] nums) {
        // 思路 时间复杂度为o(n),使用双指针的思想，没有说原地的更新数组，可以开辟一个新的内存空间
        // l r 指向数组的两端 从里面选一个较大的，从大到小进行赋值。
        int n = nums.length;
        int [] res = new int[n];
        int l=0,r=n-1;
        int i = n-1;
        while(l<=r){
            if(Math.abs(nums[l])>=Math.abs(nums[r])){
                res[i--] = nums[l]*nums[l];
                l++;
            }else{
                res[i--] = nums[r]*nums[r];
                r--;
            }
        }
        return res;
    }
}
