package com.boshrong.leetcode.dp;

public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        // 分割等和子集 使用0 1 背包
        // 一维数组，从小到大遍历背包容量是完全背包
        // 从大到小是0 1 背包  dp[i] 剩余容量为i 的最大价值。
        // nums[i] 对应着 01 背包中物品重量 weight[i] 和 value [i]
        // 如果 dp[total/2] = total/2 说明能划分为两个等和子集。,价值也是背包容量，最后判断total/2 容量的价值是否为total/2,是则可以分为2个等和子集。
        int total=0;
        int m = nums.length;
        for(int i=0;i<m;i++){
            total+=nums[i];
        }
        if(total%2 != 0){
            return false;
        }
        total = total/2;

        int [] dp = new int[total+1];
        dp[0] = 0;
        //先遍历物品，再遍历容量
        for(int i=0;i<m;i++){
            for(int j=total; j>=0;j--){
                // 背包容量大于当前啊物品
                if(j>=nums[i]){
                    dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
                }
            }
        }
        return dp[total]==total;
    }
}
