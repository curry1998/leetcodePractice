package com.boshrong.leetcode.dp;

public class 粉刷房子dp {
    public int minCost(int[][] costs) {
        // 思想 dp[i][j] 0~i 房子粉刷成j颜色的最小成本。j只能取三个数
        // 状态转移方程 : dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + costs[0]
        // dp[i][1] = min(dp[i-1][0],dp[i-1][2]) + costs[1]
        // dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + costs[2]
        int n = costs.length;
        int [][] dp = new int [n][3];
        for(int i =0;i < 3; i++){
            dp[0][i] = costs[0][i];
        }
        for(int i = 1; i < n; i++){
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + costs[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + costs[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + costs[i][2];
        }
        int res = Math.min(dp[n-1][0], dp[n-1][1]);
        return Math.min(dp[n-1][2], res);

    }
}
