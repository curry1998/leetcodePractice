package com.boshrong.leetcode.dp;

public class 第N个泰波那契数1137 {

    public static void main(String[] args) {
        System.out.println(tribonacci(25))  ;
    }
    public static  int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n<3) {
            return 1;
        }
        int [] dp=new  int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<n+1;i++){
            dp[i]=dp[i-3]+dp[i-2]+dp[i-1];
        }
        return dp[n];

    }

}
