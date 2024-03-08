package com.boshrong.leetcode.数学;



import java.util.ArrayList;

public class 顺时针打印矩阵jz23 {


    // 思想可以看旋螺旋矩阵二
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if(m==0){
            return new int[]{};
        }
        int n = matrix[0].length;
        int [] res = new int[m*n];
        int l = 0,r = n-1,t = 0, b = m-1;
        int pos = 0;
        while(pos<m*n){
            // 左闭右开
            for(int i = l;i<=r && pos<m*n;i++)
                res[pos++] = matrix[t][i];
            t++;
            for(int i = t;i<=b && pos<m*n; i++)
                res[pos++] = matrix[i][r];
            r--;

            for(int i =r;i >= l && pos<m*n;i--)
                res[pos++] = matrix[b][i];
            b--;

            for(int i =b;i >=t && pos<m*n;i--)
                res[pos++] = matrix[i][l];
            l++;
        }
        return res;
    }
}
