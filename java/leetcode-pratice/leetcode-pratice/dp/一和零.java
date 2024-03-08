package com.boshrong.leetcode.dp;

public class 一和零 {
    public static void main(String[] args) {
        findMaxForm(new String[]{"10", "0", "1"},1,1);
    }
    public static int findMaxForm(String[] strs, int m, int n) {
        // 思路: 01 背包问题，但是求的集合个数 weight 是 0 1的个数 value 是个数
        //  需要知道这个字符串有多少个 0 和 1
        // 使用一个二维数组，dp[i][j] 剩余i 个0，j 个1 的最大子集个数。
        // 状态转移方程: dp[i][j] = Math(dp[i][j],dp[i-该集合0的个数][j-该集合1的个数]+1)
        // 二维01背包问题
        int [][] dp= new int[m+1][n+1];
        int lens = strs.length;
        dp[0][0]=0;
        for(int k =0;k<lens;k++){
            int [] num = getNum(strs[k]);
            for(int i=m;i>=0;i--){
                for(int j=n;j>=0;j-- )
                    if(i>=num[0] && j>=num[1]){
                        dp[i][j]= Math.max(dp[i][j],dp[i-num[0]][j-num[1]]+1);
                    }
            }
        }
        return dp[m][n];
    }
    public static int[] getNum(String s){
        int n = s.length();
        int count0 = 0;
        int count1 = 0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                count0++;
            }else{
                count1++;
            }
        }
        return new int[]{count0,count1};
    }
}
