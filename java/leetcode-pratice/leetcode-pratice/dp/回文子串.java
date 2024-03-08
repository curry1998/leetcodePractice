package com.boshrong.leetcode.dp;

public class 回文子串 {
    public int countSubstrings(String s) {
        // 回文子串个数，回溯也可以做，动态规划也可以做
        // 动态规划 dp[i][j] 表示字符串 i 到j 是否为回文子串 i<j
        // s[i]=s[j] j-i<=1 则为回文子串， s[i]=s[j] j-i>1 则需要判断 dp[i+1][j-1] 是否为回文子串,为回文子串为true，不是则返回false
        // 状态转移方程为 dp[i][j]=(s[i][j] && dp[i+1][j-1])
        // 左下角，从下往上填,从左往右填
        int n= s.length();
        int ans =0;
        boolean [][] dp = new boolean[n][n];

        // i 列 从下到上
        for(int i=n-1;i>=0;i--){
            // j 行从左向右
            for(int j=i;j<n;j++){
                if((s.charAt(i)==s.charAt(j)) &&(j-i<=1 || dp[i+1][j-1])){
                    ans++;
                    dp[i][j] =true;
                }
            }
        }
        return ans;
    }
}
