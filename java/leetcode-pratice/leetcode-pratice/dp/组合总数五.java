package com.boshrong.leetcode.dp;

public class 组合总数五 {
    public int combinationSum4(int[] nums, int target) {
        // 这道题就是零钱总和二的变形,多了一个不同的顺序。
        // 回溯也可以做
        //如果求组合数就是外层for循环遍历物品，内层for遍历背包。因为遍历遍历物品，只会出现{1，5}，而不会出现{5，1} 这种情况。
        // 如果求排列数就是外层for遍历背包，内层for循环遍历物品。
        int n = nums.length;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];
            }

        }
        return dp[target];
    }
}
