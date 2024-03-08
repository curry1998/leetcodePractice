package com.boshrong.leetcode.dp;

public class 打家劫舍二 {
    public int rob(int[] nums) {
        // 这道题与打家劫舍1 不同在于，其是连成环的。
        // 因为首和尾只能考虑一个，分成两类: 考虑尾节点 和 考虑 首节点。 两者取最大。其计算过程与打家劫舍1相同
        int n = nums.length;
        if(n < 2){
            return nums[n-1];
        }
        int head = getMaxValue(nums,0, n - 2);
        int tail = getMaxValue(nums, 1, n-1);
        return Math.max(head, tail);

    }
    public int getMaxValue(int [] nums, int l, int r){
        int n = r - l + 1;
        int [] dp = new int [n];
        dp[0] = nums[l];
        if(n > 1){
            dp[1] = Math.max(nums[l] , nums[l+1]);
        }
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i-2] + nums[i+l], dp[i-1]);
        }
        return dp[n - 1];
    }
}
