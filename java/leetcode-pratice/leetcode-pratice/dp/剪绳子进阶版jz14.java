package com.boshrong.leetcode.dp;

public class 剪绳子进阶版jz14 {

    // 动态规划 和贪心算法实现 但是要求余 用贪心求解
    public int cuttingRope(int n) {
        // m>1 必须要剪一段 小于4 要特殊判断
        if(n<=3){
            return n-1;
        }
        // 状态转移方程 f(k)=max(f(i)*f(k-i))  0<i<n  f(k) 长度为k的绳子剪成若干段的乘积最大值
        int [] dp=new int[n+1];
        // 初始化
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        dp[4]=4;
        for(int k=5;k<=n;k++){
            int currentResult=Integer.MIN_VALUE;
            for(int i=1;i<=k;i++){
                int value=dp[i] *dp[k-i];
                if(value>currentResult){
                    currentResult=value;
                }
            }
            dp[k]=currentResult;
        }

        return dp[n];
    }
}
