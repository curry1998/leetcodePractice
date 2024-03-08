package com.boshrong.leetcode.dp;

public class 礼物的最大价值jz47 {
    public int maxValue (int[][] grid) {
        int rowLens=grid.length;
        int clomnLens=grid[0].length;

        int[][] dp=new int[rowLens][clomnLens];
        //状态转移方程 dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j])

        //初始化第一行和第一列
        int count=0;
        for(int i=0;i<clomnLens;i++){
            count+=grid[0][i];
            dp[0][i]=count;
        }
        count=0;
        for(int i=0;i<rowLens;i++){
            count+=grid[i][0];
            dp[i][0]=count;
        }


        for(int i=1;i<rowLens;i++){
            for(int j=1;j<clomnLens;j++){
                dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j])+grid[i][j];
            }
        }
        return dp[rowLens-1][clomnLens-1];
    }
}
