package com.boshrong.leetcode.贪心;

public class 跳跃游戏贪心 {
    public boolean canJump(int[] nums) {
        // 动态规划:dp[i] 能否跳到第i 个位置 dp[i]=(dp[j] && i-j<nums[j]) j<i 是小于i 的一个数。
        // 贪心: 找到可以覆盖的区域中每一个点所能覆盖的最大区域 第i个位置+ nums[i]，最后查看cover 是否大于等于nums的长度
        int n = nums.length;
        if(n<=0){
            return false;
        }

        int cover =nums[0];
        // 注意i 小于等于cover，并不断的更新cover
        for(int i=0;i<=cover;i++){
            cover = Math.max(i+nums[i],cover);
            if(cover>=n-1){
                return true;
            }
        }
        return false;
    }
}
