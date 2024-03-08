package com.boshrong.leetcode.数学;

public class 旋转图像 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        //思路： 先对角线 再水平
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }

        // 垂直翻转,对角线翻转没问题，看垂直翻转
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int tmp=matrix[j][i];
                matrix[j][i]=matrix[j][n-i-1];
                matrix[j][n-i-1]=tmp;
            }
        }
    }
}
