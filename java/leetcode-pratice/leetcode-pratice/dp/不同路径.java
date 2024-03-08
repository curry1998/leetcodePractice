package com.boshrong.leetcode.dp;

public class 不同路径 {
    // 使用dp
    //思路 f[i][j]表示从1 1到 i,j 的路径数， 只能从下或向右走，状态转移方程 f[i][j]=(f[i-1][j]+f[i][j-1])
    public int uniquePaths(int m, int n) {
        int [][] f=new int[m+1][n+1];
        //按行算,初始化
        for(int i=1;i<=n;i++){
            f[1][i]=1;
        }
        for(int i=1;i<=m;i++){
            f[i][1]=1;
        }

        for(int i=2;i<=m;i++){
            for(int j=2;j<=n;j++){
                f[i][j]=f[i-1][j]+f[i][j-1];
            }
        }
        return f[m][n];
    }
}
