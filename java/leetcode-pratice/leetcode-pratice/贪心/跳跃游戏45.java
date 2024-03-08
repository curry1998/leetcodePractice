package com.boshrong.leetcode.贪心;

public class 跳跃游戏45 {
    public static void main(String[] args) {
        jump(new int[]{2,3,1,1,4});
    }
    public static int jump(int[] nums) {
        int lens=nums.length;
        int val = nums[0];
        int idx = 0;
        int res=0;
        while(idx<lens-1){
            int minValue=Integer.MIN_VALUE;
            int currentidx=idx;
             int currentValue=val;
            Boolean falg=false;
            for(int i=1;i<=val;i++){
                if(idx+i<lens-1 &&minValue<=(nums[idx+i]+i)) {
                    minValue=nums[idx+i];
                    currentValue=minValue;
                    currentidx=idx+i;
                    continue;
                }
                if(idx+i==lens-1){
                    falg=true;
                }

            }
            if(falg){
                res++;
                break;
            }
            idx=currentidx;
            val=currentValue;
            res++;
        }
        return res;
    }
}
