package com.boshrong.leetcode.滑动窗口;

public class 长度最小的子数组 {
    public int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口
        // 滑动窗口
        int n = nums.length;
        int res = n+1;
        int l=0,r=0;

        while(r<n){
            target-=nums[r];
            while(target<=0){
                if((r-l+1)<=res){
                    res = r-l+1;
                }
                target+=nums[l];
                l++;
            }
            r++;
        }
        return res==n+1? 0:res;
    }
}
