package com.boshrong.leetcode.dp;

import java.util.Arrays;

public class 完全平方数279 {
    public int numSquares(int n) {
        // dp[n] 和为n 的最少完全平方数。 类似与完全背包 求最小数，怎么遍历都可以(为了方便先遍历背包)
        // 递推公式  dp[n] = min(dp[n], dp[n -j * j ]+1) 1 < j < sqrt(i)
        int [] dp = new int[n + 1];
        Arrays.fill(dp,n+1);
        dp[0] = 0; //0*0 不可能存在
        for(int i = 0; i <= n; i++){
            for(int j = 1; j <= Math.sqrt(i); j++){
                dp[i] =Math.min(dp[i], dp[i -j*j] + 1);
            }
        }
        return dp[n];
    }
}
