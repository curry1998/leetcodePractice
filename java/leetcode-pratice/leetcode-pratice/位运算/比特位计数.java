package com.boshrong.leetcode.位运算;

public class 比特位计数 {
    public int[] countBits(int n) {
        // 思路: 表示1 的个数， 动态规划 i 为基数 dp[i]= dp[i/2]+1; i为偶数 为前一个偶数 dp[i]= dp[i/2];
        if(n==0){
            return new int[]{0};
        }
        int [] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            if(i%2==0){
                dp[i] = dp[i/2];
            }else{
                dp[i] = dp[i/2]+1;
            }
        }
        return dp;
    }
}
