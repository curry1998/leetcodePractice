package com.boshrong.leetcode.dp;

import java.util.HashMap;

public class 最长不含重复字符的子字符串 {
    public static void main(String[] args) {
        String a="pwdedwkew";
        lengthOfLongestSubstring(a);
    }

    public static int lengthOfLongestSubstring (String s) {

        //这个方法有问题
        int lens=s.length();
        if(lens<1){
            return 0;
        }
        //存储中间结果
        int[] dp = new int[lens];

        // 定义一个hashmap 存储不重复字符及其出现的位置
        HashMap<Character, Integer> hashmap = new HashMap<>();
        dp[0]=1;
        hashmap.put(s.charAt(0),0);

        for(int i=1;i<lens;i++){

            //hashmap 中没有
            if(!hashmap.containsKey(s.charAt(i))){
                hashmap.put(s.charAt(i),i);
                dp[i]=dp[i-1]+1;
            }else{
                // hashmap 中有, 获取位置
                int pos = hashmap.get(s.charAt(i));
                dp[i]=i-pos;
                //更新当前字符的位置
                //要将hashmap 中pos 到i 的char 放入hashmap 中 debug 时候才发现问题

                hashmap.clear();
                for(int j=pos+1;j<=i;j++){
                    hashmap.put(s.charAt(j),j);
                }
            }
        }
        int result=Integer.MIN_VALUE;
        for(int i=0;i<lens;i++){
            if(dp[i]>result){
                result=dp[i];
            }
        }
        return result;
    }
}
