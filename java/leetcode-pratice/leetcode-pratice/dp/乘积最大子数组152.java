package com.boshrong.leetcode.dp;

public class 乘积最大子数组152 {
    public int maxProduct(int[] nums) {
        // 思路:  dp[i] 以i 为结尾 的最大值，因为有负数。 f[i] 以i结尾的最小值
        // 从 前面推 ai  ai>=0 dp[i]=dp[i-1]*ai,  ai<0 dp[i]=f[i-1]*ai;
        // ai<0  ai>=0 f[i]=f[i-1]*ai  ai<0 f[i]=dp[i-1]*ai;
        int lens=nums.length;
        int [] dp=new int[lens];
        int [] f=new int [lens];
        dp[0]=nums[0];
        f[0]=nums[0];
        for(int i=1;i<lens;i++){
            if( nums[i]>=0){

                dp[i]=Math.max(dp[i-1]*nums[i],nums[i]);
                f[i]=Math.min(f[i-1]*nums[i],nums[i]);
                continue;
            }
            if( nums[i]<0){
                dp[i]=Math.max(f[i-1]*nums[i],nums[i]);
                f[i]=Math.min(dp[i-1]*nums[i],nums[i]);
                continue;
            }

        }
        int maxValue=Integer.MIN_VALUE;
        for(int i=0;i<lens;i++){
            if(dp[i]>maxValue){
                maxValue=dp[i];
            }
        }
        return maxValue;

    }
}
