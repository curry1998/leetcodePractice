package com.boshrong.leetcode.dp;

public class 不相交的线 {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 最长重复数组
        //dp[i][j] nums1 前i位与nums2 前j 位的 最长重复子数组.
        // dp[i][j] = (dp[i-1][j-1]+1) nums[i]==nums[j]
        // dp[i][j] = max(dp[i-1][j],dp[i][j-1]) nums[i]!=nums[j] 从上面和左边挑选一个最大值
        // 不连续下面是正确的，子数组要求的是连续
        int n = nums1.length;
        int m = nums2.length;
        int [][] dp = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];

    }
}
