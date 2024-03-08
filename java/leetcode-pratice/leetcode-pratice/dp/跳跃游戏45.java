package com.boshrong.leetcode.dp;

public class 跳跃游戏45 {

    public int jump(int[] nums) {
        int lens=nums.length;
        if(lens==0){
            return 0;
        }
        int [] dp=new int [lens];
        dp[0]=0;
        for(int i=1;i<lens;i++){
            dp[i]=10001;
            for(int j=0;j<i;j++){
                if(i-j<=nums[j]&& dp[i]==10001){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[lens-1];
    }
}
