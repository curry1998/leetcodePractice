package com.boshrong.leetcode.数学;

public class 两数相除29 {
    public static void main(String[] args) {
        divide(-2147483648,1);
    }
    public static int divide(int dividend, int divisor) {
        if(divisor==0){
            return 0;
        }
        // >>> 无符号右移动
        int flag=(dividend^divisor)>>>31==1?-1:1;
        int count=0;
        long undividend=Math.abs(dividend);
        long undivisor=Math.abs(divisor);

        while(undividend>=undivisor){
            //重新赋值。
            int i=1;
            // 使用tmp 代表每次增长的那个数
            long tmp=undivisor;
            while(undividend>=tmp){
                //步数增长
                undividend-=tmp;
                count+=i;
                i=i<<1;
                tmp=tmp<<1;
            }
        }
        count=count*flag;
        if(count>=Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(count<=Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return count;
    }
}
