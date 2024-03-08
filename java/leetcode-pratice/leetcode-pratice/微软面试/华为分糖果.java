package com.boshrong.leetcode.微软面试;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class 华为分糖果 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m =sc.nextInt();
        int [] nums=new int[m];
        int total=0;
        for(int i=0;i<m;i++){
            nums[i]=sc.nextInt();
            total+=nums[i];
        }
        if(total%2!=0){
            System.out.println(-1);
        }
        ArrayList<Integer> list=divideCandy(total/2,nums,m);
        System.out.println();

    }
    public static ArrayList<Integer>  divideCandy(int total,int [] nums,int m){

        // 可以将这道题转化为01背包问题，total 就是所有和的一半，从背包里面找，找到保存其位置
        // dp[i] 背包剩余为 i 的所能选的最小次数。 dp[i]=min(dp[i] 不选,dp[i-nums[j]]+1)
        // 使用一个set 进行保存。要找路径

        int [] dp=new int[total+1];
        dp[0]=0;
        ArrayList<Integer> path=new ArrayList<>();
        for(int i=1;i<total;i++){
            for(int j=m-1;j>=0;j--){
                // 背包容量大于当前啊物品
                if(i>nums[j]){
                    if(dp[i-nums[j]]+1>dp[i]){
                        path.add(j);
                    }
                    dp[i]=Math.min(dp[i],dp[i-nums[j]]+1);
                }
            }
        }
        return path;
    }

}
