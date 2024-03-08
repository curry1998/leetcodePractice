package com.boshrong.leetcode.二分;

public class 快速幂 {
    public double myPow(double x, int n) {

        if(n==0){
            return 1;
        }
        long N=Math.abs(n);
        double res=pow(x,N);
        return n>0?res:1/res;
    }
    public double pow(double x,long n){
        if(n==1){
            return x;
        }
        if(n==0){
            return 1.0;
        }
        // 将递归操作抽出来
        // 时间复杂度为o(logn)
        double tmp=pow(x,n/2);
        if(n%2!=0){
            return tmp*tmp*x;
        }
        return tmp*tmp;
    }
}
