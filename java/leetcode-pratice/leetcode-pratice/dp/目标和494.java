package com.boshrong.leetcode.dp;

public class 目标和494 {
    public int findTargetSumWays(int[] nums, int target) {
        // 思路:  目标和 0 1 背包的思想
        // 正数 总和 x  ，负数总和 total -x  则 x -(total -x) = target 则 x=(total+target)/2 这与分割等和子集很像，但要求的是求个数。
        // dp[j]： 背包容量为i 所能构造的表达式数目 状态转移方程  dp[j] += dp[j-nums[i]]
        // 求装满背包有几种方式，递推公式为 dp[]
        int n = nums.length;

        //dp[0] = 1 表示 target 为 0 一个数都不选
        int total = 0;
        for(int num : nums){
            total+=num;
        }
        if((total+target)%2!=0 || (total+ target)/2 <0){
            return 0;
        }
        target =(total + target) /2;
        int [] dp = new int[target+1];
        dp[0] = 1;
        for(int i = 0; i<n;i++){
            for(int j = target; j>=0;j--){
                if(j>=nums[i])
                    dp[j] += dp[j-nums[i]];
            }
        }
        return dp[target];
    }
}
