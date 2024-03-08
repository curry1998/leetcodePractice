package com.boshrong.leetcode.dp;

public class 判断子序列 {
    public boolean isSubsequence(String s, String t) {
        // dp[i][j] 以i 结尾的字符串s 与j 结尾的字符串t,相同子序列的长度
        // 如果s[i]=t[j] 则 dp[i][j] = dp[i-1][j-1] + 1
        // 如果 s[i] != t[j] 则 dp[i][j] = dp[i][j-1] i不变，j 要依靠j-1 ， 相当于删除t 中j的位置。
        // 最后判断 dp[m][n] 是否等于s 的长度，等于说明是子序列
        int n = s.length();
        int m = t.length();
        int [][] dp= new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j =1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[n][m]==s.length()-1;
    }
}
