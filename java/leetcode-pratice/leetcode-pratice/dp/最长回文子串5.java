package com.boshrong.leetcode.dp;

public class 最长回文子串5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome2("ac"));
    }

    public String longestPalindrome(String s) {
        int lens=s.length();

        if(lens<2){
            return s;
        }
        // 记录最长回文串的开始位置和最长位置
        int maxLen=0;
        int begin=0;

        for(int i=0;i<lens-1;i++){
            for (int j=i;j<lens;j++){
                if(j-i+1>maxLen && checkPalindrome(s,i,j)){
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }
    public boolean checkPalindrome(String s,int begin,int end){
        while(begin<end){
            if(s.charAt(begin)!=s.charAt(end)){
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }



    public static  String longestPalindrome2(String s) {
        int lens=s.length();
        if(lens<2){
            return s;
        }
        boolean [][] dp=new boolean[lens][lens];
        for(int i=0;i<lens;i++){
            dp[i][i]=true;
        }
        //默认最小为1个
        int maxLens=1;
        int begin=0;
        //先填列，再填行
        // i 右边界 j 左边界
        for(int j=1;j<lens;j++){
            for(int i=0;i<j;i++){
                if(s.charAt(i)==s.charAt(j) &&(j-i<3 || dp[i+1][j-1])){
                    dp[i][j]=true;
                    if(j-i+1>maxLens){
                        maxLens=j-i+1;
                        begin=i;

                    }
                }
                else {
                    dp[i][j]=false;
                }
            }

        }

        return s.substring(begin,begin+maxLens);
    }
}
