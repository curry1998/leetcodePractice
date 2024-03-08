package com.boshrong.leetcode.队列栈;

import java.util.ArrayDeque;

public class 最长有效括号 {
    public int longestValidParentheses(String s) {
        // 求最长 动态规划 dp[i]= 第i个元素和栈顶元素不匹配 dp[i]=dp[i-1]
        //  匹配 dp[i]=dp[i-1]+2
        // 注意还要连续
        int len1=s.length();
        if(len1==0){
            return 0;
        }
        int[] dp=new int[len1];
        ArrayDeque<Character> stack=new ArrayDeque<>();
        for(int i=0;i<len1;i++){
            if(stack.isEmpty()){
                if(s.charAt(i)=='(') {
                    stack.add('(');
                }
                if(i>0){
                    dp[i]=dp[i-1];
                }else{
                    dp[0]=0;
                }
                continue;
            }
            if(!stack.isEmpty() && s.charAt(i)=='('){
                stack.add('(');
                dp[i]=dp[i-1];
            }
            if(!stack.isEmpty() && s.charAt(i)==')'){
                stack.poll();
                dp[i]=dp[i-1]+2;
                continue;
            }

        }
        return dp[len1-1];

    }
}
