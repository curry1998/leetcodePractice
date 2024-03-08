package com.boshrong.leetcode.数学;

public class 剑指offer简单题 {
    public int[] printNumbers (int n) {
        // write code here
        if (n<1){
            return new int[]{};
        }
        //将double 转为int
        double nums=Math.pow(10,n);
        int count = new Double(nums).intValue()-1;
        int[] ints = new int[count];
        for(int i=1;i<=count;i++){
            ints[i-1]=i;
        }
        return ints;
    }

    //排序数组中查找数字
    public int search (int[] nums, int target) {
        int lens=nums.length;
        if(lens<0){
            return 0;
        }
        int count=0;
        for(int i=0;i<lens;i++){
            if (nums[i]==target){
                count++;
            }
        }
        return count;
    }
}
