package com.boshrong.leetcode.数学;

public class 数值的整数次方jz16 {
    public double Power(double base, int exponent) {
        if(base==0.0){
            return 0.0;
        }
        if(exponent==0){
            return 1.0;
        }
        double res=1;
        for(int i=1;i<=Math.abs(exponent);i++){
            res*=base;
        }
        if(exponent<0){
            res=1/res;
        }
        return res;
    }
}
