package com.boshrong.leetcode.技巧;

public class 前缀和子数组最大平均数643 {

    public static double findMaxAverage(int[] nums, int k) {
        // 思想: 前缀和 或者滑动窗口
        // 这里使用前缀和
        int n = nums.length;
        int [] preSum = new int [n+1];
        preSum[0] = 0;
        for(int i = 1; i <= n; i++){
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        double maxValue = (double)Integer.MIN_VALUE;
        for(int i = 0,j = k; j < n + 1; i++,j++){
            double num =(double)( preSum[j] - preSum[i])/(double) k;
            if(num > maxValue){
                maxValue = num;
            }
        }
        return maxValue;
    }
}
