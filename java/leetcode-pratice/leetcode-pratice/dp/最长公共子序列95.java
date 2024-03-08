package com.boshrong.leetcode.dp;

public class 最长公共子序列95 {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(longestCommonSubsequence(text1,text2));
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        // dp[i][j] text[]
        if(text1==null||text2==null){
            return 0;
        }
        int len1=text1.length();
        int len2=text2.length();
        int [][] dp=new int[len1+1][len2+1];
        //边界赋值为0 加1 是为了让边界全部设为0
        for(int i=0;i<len1+1;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<len2+1;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<len1+1;i++){
            for (int j=1;j<len2+1;j++){
                //这个二维数组的计算是一行一行的计算
                // 注意与矩阵连乘问题的区别
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    // 从左边和上边边选元素
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
