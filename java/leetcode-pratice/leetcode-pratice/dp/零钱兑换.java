package com.boshrong.leetcode.dp;

import java.util.Arrays;

public class 零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        // 动态规划  完全背包
        // dp[i] 剩余钱为i个的，能凑成的最少硬币个数
        // dp[i]=min(dp[i],dp[i-coins[k]]+1)
        // 一个是不选该硬币，一个是选该硬币
        int [] dp=new int[amount+1];
        int max=amount+1;
        Arrays.fill(dp,max);
        int lens=coins.length;
        dp[0]=0;
        int n = coins.length;
        // 遍历物品
        for(int i =0; i<n;i++){
            for(int j= 1;j<=amount;j++ ){
                if(j>=coins[i]){
                    dp[j] = Math.min(dp[j],dp[j-coins[i]]+1);
                }
            }
        }
        return dp[amount]==max ?-1:dp[amount];
    }
}
