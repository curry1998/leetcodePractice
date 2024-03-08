package com.boshrong.leetcode.数学;

public class 旋转矩阵 {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        // 水平
        for(int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[n-i-1][j];
                matrix[n-i-1][j]=tmp;
            }
        }

        // 主对角线交换
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
    }
}
