package com.boshrong.leetcode.dp;

public class 整数拆分343 {
    // 思想: dp[i] 分拆数字i,
    // dp[i] 表示拆分整数i，可以得到的最大乘积
    // dp[N] = Max(dp[N], dp[i]*dp[N-i]) i 从 1 到 N/2，因为N/2 到N 就重复了
    public int integerBreak(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        if(n == 3){
            return 2;
        }
        //因为dp 可以考虑不切
        int [] dp = new int [n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int N = 4; N <= n; N++){
            // dp[i] 和 dp[N-i] 在之前已经算过了
            for(int i = 1; i <=(N/2); i++){
                dp[N] = Math.max(dp[N],dp[i] * dp[N-i]);
            }
        }
        return dp[n];
    }
}
