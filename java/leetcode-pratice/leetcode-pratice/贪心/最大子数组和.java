package com.boshrong.leetcode.贪心;

public class 最大子数组和 {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {
        // 贪心 和动态规划都能做，之前使用的动态，这里使用贪心
        // 如果连续子数组和为负数，则放弃该连续子数组
        // 遍历nums ,count 从头到开始用于累加，count+nums[i]<0,则从nums[i+1] count 从0 累加
        int n = nums.length;
        int count= 0;
        int res = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            count+=nums[i];
            if(count>res){
                res = count;
            }
            if(count<=0){
                count = 0;
            }
        }
        return res;
    }
}
