package com.boshrong.leetcode.dp;

public class 把数字翻译成字符串jz46 {

    public static void main(String[] args) {
        translateNum(542);
        solve("1");

    }

    public static int translateNum(int num) {
        // 把int 转为字符串方便操作
        String s = String.valueOf(num);
        int lens=s.length();
        if(lens<1){
            return 0;
        }
        // dp[i] 表示以i 结尾能能翻译成的字符串的种类数
        int [] dp=new int[lens];
        // 初始化
        dp[0]=1;
        if(lens==1){
            return dp[0];
        }
        if(Integer.parseInt(s.substring(0,2))>=10 && Integer.parseInt(s.substring(0,2))<=25){
            dp[1]=2;
        }else{
            dp[1]=1;
        }

        for(int i=2;i<lens;i++){
            if(Integer.parseInt(s.substring(i-1,i+1))>=10 && Integer.parseInt(s.substring(i-1,i+1))<=25){
                dp[i]=dp[i-1]+dp[i-2];
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[lens-1];
    }


    //剑指offer 解题
    public static int solve (String s) {
        // write code here
        // a 对应的是1 z对应的是26
        int lens=s.length();
        if(lens<1){
            return 0;
        }
        // dp[i] 表示以i 结尾能能翻译成的字符串的种类数
        int [] dp=new int[lens];
        // 初始化
        if(s.charAt(0)>='1' && s.charAt(0)<='9')
            dp[0]=1;
        if(lens==1){
            return dp[0];
        }

        if(s.charAt(1)=='0'){
            dp[0]=0;
        }
        if(Integer.parseInt(s.substring(0,2))>=10 && Integer.parseInt(s.substring(0,2))<=26){
            dp[1]=1+dp[0];
        }else{
            dp[1]=dp[0];
        }

        for(int i=2;i<lens;i++){
            if(s.charAt(i)=='0'){
                dp[i-1]=0;
            }
            if(Integer.parseInt(s.substring(i-1,i+1))>=10 && Integer.parseInt(s.substring(i-1,i+1))<=26){
                dp[i]=dp[i-1]+dp[i-2];
            }else{
                dp[i]=dp[i-1];
            }
        }
        return dp[lens-1];
    }
}
