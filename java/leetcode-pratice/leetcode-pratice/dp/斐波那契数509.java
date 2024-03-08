package com.boshrong.leetcode.dp;

public class 斐波那契数509 {
    public static void main(String[] args) {
        System.out.println(fib(4));
    }
    public static int fib(int n) {
        //n 是一个数，不从0开始
        if(n<1){
            return 0;
        }
        if(n==1){
            return 1;
        }
        int [] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        for (int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
