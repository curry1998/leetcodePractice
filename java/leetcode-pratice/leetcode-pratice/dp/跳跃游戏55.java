package com.boshrong.leetcode.dp;

import java.util.Scanner;

public class 跳跃游戏55 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(a+b);
        }
    }
    public boolean canJump(int[] nums) {
        int lens=nums.length;
        boolean [] dp=new boolean[lens];
        dp[0]=true;
        for(int i=1;i<lens;i++){
            for(int k=i-1;k>=0;k--){
                if(dp[k]==true && (i-k)<=nums[k]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[lens-1];
    }
}
