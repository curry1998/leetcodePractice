package com.boshrong.leetcode.二分;

public class x的平方根 {
    public static void main(String[] args) {
        mySqrt(8);
    }
    public static int mySqrt(int x) {
        // 思想 二分，0~x 是有序的。将1~x 取中点，判断中间点的平方是否大于等于x ，不满足进行二分
        // 为了防止溢出 使用 x/mid<=mid
        int l =1, r=x;

        while(l<r){

            int mid = (l+r+1)/2;
            if(x/mid>=mid){
                l = mid;
            }else{
                r = mid-1;
            }
        }
        return l;

    }
}
