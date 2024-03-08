package com.boshrong.leetcode.dp;

public class 解码方法 {
    public static void main(String[] args) {
        numDecodings("06");
    }
    public static int numDecodings(String s) {
        int n=s.length();
        if(n==1&& s.charAt(0)=='0'){
            return 0;
        }
        // 动态规划 dp[i]=dp[i-1] || dp[i-1]+1 (10<=dp[i-1]与dp[i]<=26)
        int [] dp=new int[n];
        if(s.charAt(0)!=0) {
            dp[0] = 1;
        }else{
            dp[0]=0;
        }
        for(int i=1;i<n;i++){
            int num=Integer.parseInt(s.substring(i-1,i+1));
            if(s.charAt(i-1)=='0'){
                dp[i]=dp[i-1];
                continue;
            }
            if(num>=10 && num<=26){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[n-1];
    }
}
