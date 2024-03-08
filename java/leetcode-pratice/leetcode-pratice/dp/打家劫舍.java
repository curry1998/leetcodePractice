package com.boshrong.leetcode.dp;

public class 打家劫舍 {
    public int rob(int[] nums) {
        // 动态规划  dp[i] 第i 个房子的最大收益。 这个房子有偷和不偷两种情况。
        // dp[i] = Max(dp[i-2]+ nums[i] 偷, dp[i-1] 不透)
        int n = nums.length;
        int [] dp = new int [n ];
        dp[0] = nums[0];
        if(n > 1){
            dp[1] = Math.max(nums[0], nums[1]);
        }
        for(int i = 2; i <  n ; i++){
            dp[i] = Math.max(dp[i -2] + nums[i], dp[i-1] );
        }
        return dp[n-1];
    }
}
