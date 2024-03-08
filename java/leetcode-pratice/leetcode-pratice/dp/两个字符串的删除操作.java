package com.boshrong.leetcode.dp;

public class 两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {
        // 两个字符串都有操作
        // dp[i][j] word1 中以i 结尾，word2 中以j 结尾，相同的最小步数。
        // word1[i-1]= word2[j-1] dp[i][j] =dp[i-1][j-1] 无步数操作
        // word1[i-1] != word2[j-1]  dp[i][j] =min(dp[i-1][j]+1 删除word1 第i个位置,dp[i][j-1]+1,dp[i-1][j-1]+2)
        // 初始化 dp[i][0] 为i 表示word1 中删除几个元素才能变成空字符串 。dp[0][i]
        int n = word1.length();
        int m = word2.length();
        int [][] dp= new int[n+1][m+1];
        for(int i =0;i<=n;i++){
            dp[i][0] = i;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] =i;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(dp[i-1][j]+1,dp[i][j-1]+1);
                    dp[i][j] = Math.min(dp[i][j],dp[i-1][j-1]+2);
                }
            }
        }
        return dp[n][m];
    }
}
