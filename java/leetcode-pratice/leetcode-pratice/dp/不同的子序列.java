package com.boshrong.leetcode.dp;

public class 不同的子序列 {
    public int numDistinct(String s, String t) {
        // 动态规划，这一道题与编辑距离很相似。编辑距离有删除，替换，修改，这一题只有删除
        // dp[i][j] s 中以i 结尾的子序列，t在 中以j 结尾的的子序列中出现的个数
        // 因为求的是个数，当s[i-1]==s[t-1] 时，有选或者不选s中i-1位置是否删除两个选择，将两个选择进行相加。
        // s[i-1]==t[j-1] dp[i][j]=dp[i-1][j] 删除+ dp[i-1][j-1] 匹配
        // s[i-1] !=t[j-1] dp[i][j] = dp[i-1][j]
        int n = s.length();
        int m = t.length();
        int [][] dp= new int [n+1][m+1];
        // dp[0][..] 初始化为 0 dp[i][0] 应该初始化为1 表示以s 中以i结尾的，全部删除，转化为t 中空串，其个数为1.

        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j] +dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][m];
    }
}
