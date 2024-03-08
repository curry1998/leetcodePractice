package com.boshrong.leetcode.dp;

public class 最长重复子数组 {
    public int findLength(int[] nums1, int[] nums2) {
        // dp[i][j] nums1 以i位结尾与nums2 以j结尾的 最长重复子数组.
        // dp[i][j] = (dp[i-1][j-1]+1) nums[i]==nums[j] 不相等dp[i][j] =0
        // 不连续下面是正确的，这个题要求连续。子数组要求的是连续
        int n = nums1.length;
        int m = nums2.length;
        int [][] dp = new int[n+1][m+1];
        int res = Integer.MIN_VALUE;
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                if(dp[i][j]>res){
                    res = dp[i][j];
                }
            }
        }
        return res;
    }
}
