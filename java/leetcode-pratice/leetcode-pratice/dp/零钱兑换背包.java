package com.boshrong.leetcode.dp;

public class 零钱兑换背包 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        //dp[i] 表示 可以凑成总金额为 i 的硬币组合数
        // dp[i] += dp[i-coins[j]]
        // dp[0] = 1 表示不凑,一种方案
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i])
                    dp[j] += dp[j - coins[i]];
            }
            for (int j = 0; j <= amount; j++) {
                System.out.printf("%d ",dp[j]);
            }
        }
        return dp[amount];
    }
}
