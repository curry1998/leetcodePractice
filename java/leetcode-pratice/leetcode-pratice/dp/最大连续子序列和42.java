package com.boshrong.leetcode.dp;

public class 最大连续子序列和42 {
    public static void main(String[] args) {
        int [] nums={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int [] dp=new int[nums.length];
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
        }
        int result=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(result<dp[i]){
                result=dp[i];
            }
        }
        return result;
    }

}
