package com.boshrong.leetcode.dp;

import java.util.Scanner;

public class 背包01一维数组 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N个物品 V 背包容量
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[][] ints = new int[N+1][2];
        for(int i=0;i<N;i++) {
            // weights
            ints[i][0] = sc.nextInt();
            // values
            ints[i][1] = sc.nextInt();
        }
        int [] dp = new int [V+1];
        dp[0] = 0;
        for(int i = 0; i<=N; i++){
            for(int j= V;j>=0;j--){
                if(j>=ints[i][0])
                    dp[j] = Math.max(dp[j], dp[j-ints[i][0]]+ ints[i][1]);
            }
        }
        System.out.println(dp[V]);
    }
}
