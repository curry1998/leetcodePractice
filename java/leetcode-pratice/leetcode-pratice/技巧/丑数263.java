package com.boshrong.leetcode.技巧;

public class 丑数263 {
    public boolean isUgly(int n) {

        if(n<1){
            return false;
        }
        if(n==1){
            return true;
        }
        // 丑数：包含质因数 2 3 5  对于n=6, 先整除第一个，能整除不断进行整除，直到整除为1，如果遍历所有丑数都不能整除，则不是丑数
        int [] nums=new int[]{2,3,5};
        for(int num:nums){
            // n不为0，n能整除nums
            while(n!=1 && n%num==0){
                n=n/num;
            }
        }

        if(n==1){
            return true;
        }else{
            return false;
        }

    }
}
