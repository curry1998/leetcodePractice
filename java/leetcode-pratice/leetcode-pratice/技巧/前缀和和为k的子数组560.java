package com.boshrong.leetcode.技巧;

public class 前缀和和为k的子数组560 {
    // 思想: 前缀和
    public int subarraySum(int[] nums, int k) {
        // 和为k 的子数组个数
        // 前缀和问题，子数组要求是连续的
        // 求出前缀和，进行遍历。
        //
        int n = nums.length;
        int [] preSum = new int[n + 1];
        preSum[0] = 0;
        for(int i=1;i<n + 1;i++){
            // preSum[i] 前i 个数的和
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        // 遍历顺序
        // 感觉可以使用动态规划
        int count = 0;
        // i，j 是原来nums 的i j
        // sum(i,j)=presum(j+1)-presum(i)
        for(int j = n - 1;j >= 0;j--){
            if(nums[j] == k){
                // 特判
                count++;
            }
            for(int i=j-1;i>=0;i--){
                // i到j 的区间的和
                if(preSum[j+1] - preSum[i] == k){
                    count++;
                }
            }
        }

        return count;
    }
}
