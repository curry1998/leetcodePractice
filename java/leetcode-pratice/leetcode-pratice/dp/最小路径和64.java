package com.boshrong.leetcode.dp;

public class 最小路径和64 {
    public int minPathSum(int[][] grid) {
        // 最短路径和 求和最小 用dp f[i][j]: 从0,0 到i,j 的最小和 f[i][j]=min(f[i-1][j],f[i][j-1])+grid[i][j]
        int len1=grid.length;
        int len2=grid[0].length;
        int[][] f=new int[len1][len2];
        // 初始化
        f[0][0]=grid[0][0];
        for(int i=1;i<len2;i++){
            f[0][i]=f[0][i-1]+grid[0][i];
        }
        for(int i=1;i<len1;i++){
            f[i][0]=f[i-1][0]+grid[i][0];
        }
        for(int i=1;i<len1;i++){
            for(int j=1;j<len2;j++){
                f[i][j]=Math.min(f[i-1][j],f[i][j-1])+grid[i][j];
            }
        }
        return f[len1-1][len2-1];

    }
}
