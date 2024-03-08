package com.boshrong.leetcode.贪心;

public class 跳跃游戏55 {
    public static void main(String[] args) {
        canJump(new int[]{1,1,2,2,0,1,1});
    }

    public  static boolean canJump(int[] nums) {
        int lens=nums.length;
        if(lens==1){
            return true;
        }
        //贪心
        int i=0;
        while(i<lens){
            int flag=i;
            int val=nums[i];
            int maxValue=Integer.MIN_VALUE;
            for(int j=1;j<=val;j++){
                if(flag+j>=lens-1){
                    return true;
                }
                if(nums[flag+j]>maxValue || j-1+nums[flag+j]>=maxValue){
                    maxValue=nums[flag+j];
                    i=flag+j;
                    if(i>=lens-1){
                        return true;
                    }
                }
            }
            if(i==flag){
                break;
            }
        }

        return false;
    }

}
