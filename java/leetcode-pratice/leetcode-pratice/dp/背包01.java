package com.boshrong.leetcode.dp;

import java.util.Scanner;

public class 背包01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N个物品 V 背包容量
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[][] ints = new int[N+1][2];
        for(int i=0;i<N;i++){
            // weights
            ints[i][0]=sc.nextInt();
            // values
            ints[i][1]=sc.nextInt();
        }

        int [][] dp=new int[N+1][V+1];
        for(int i=1;i<=N;i++){
            for(int j=0;j<=V;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=ints[i][0]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-ints[i][0]]+ints[i][1]);
                }
            }
        }

        System.out.println(dp[N][V]);

    }
}
