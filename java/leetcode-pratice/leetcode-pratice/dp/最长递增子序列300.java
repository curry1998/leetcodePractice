package com.boshrong.leetcode.dp;

public class 最长递增子序列300 {

    public static void main(String[] args) {
        int [] nums={1,2,-10,-8,-7};
        System.out.println(lengthOfLIS(nums));
    }
    public static int lengthOfLIS(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int [] dp=new int[nums.length];
        dp[0]=1;
        Boolean flag=false;
        int result=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
           for(int j=0;j<i;j++) {
               if(nums[i]>nums[j]){
                   int temp=dp[j]+1;
                   if(temp>dp[i]){
                       dp[i]=temp;
                   }
                   flag=true;
               }

           }
            //A[i] 都小于A[j] j 从0到i
            if(!flag){
                dp[i]=1;
            }
            // 重置flag
            flag=false;
        }

        for(int i=0;i<nums.length;i++){
            if(dp[i]>result){
                result=dp[i];
            }
        }
        return result;
    }

}
