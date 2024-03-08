package com.boshrong.leetcode.数学;

public class 构建乘积矩阵jz66 {
    public int[] constructArr(int[] a) {
        // 思想，可以抽象成下三角和上三角
        // 利用已算出来的结果计算
        int n = a.length;
        int [] res = new int[n];
        int t = 1; //t代表之前乘的数
        //先计算下三角
        for(int i = 0; i < n; i++){
            res[i] = t;
            t *= a[i];
        }

        t = 1;
        for(int i = n-1;i >= 0; i--){
            res[i] *= t;
            t *= a[i];
        }
        return res;
    }
}
