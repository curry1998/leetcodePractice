package com.boshrong.leetcode.微软面试;

import java.util.Scanner;

public class 合并金币_美团 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int [][] dp=new int[n+1][n+1];
        int [] money=new int[n+1];
        int [] preSum=new int[n+1];
        for(int i=1;i<=n;i++){
            money[i]=sc.nextInt();
            if(i==1){
                preSum[i]=money[i];
            }else{
                preSum[i]=preSum[i-1]+money[i];
            }
        }
        sc.close();
        // 区间不断增大
        for(int len=1;len<n;len++){
            for(int i=1;i+len<=n;i++){
                int j=i+len;
                int sum=preSum[j]-preSum[i-1];
                int min=Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    if(dp[i][k]+dp[k+1][j]<min){
                        min=dp[i][k]+dp[k+1][j];
                    }
                }
                dp[i][j]=min+sum;
            }
        }

        System.out.println(dp[1][n]);
    }
}
