package com.boshrong.leetcode.数学;

public class Pow {
    public static void main(String[] args) {
        myPow(2.1000,3);
    }
    public static double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }
       long N=Math.abs(n);
       double res=pow(x,N);
       return n>0?res:1/res;
    }
    public static double pow(double x,long n){
        if(n==0){
            return 1.0;
        }
        double tmp=pow(x,n/2);
        //可以看作
        return n%2==0?tmp*tmp:x*tmp*tmp;
    }
}
