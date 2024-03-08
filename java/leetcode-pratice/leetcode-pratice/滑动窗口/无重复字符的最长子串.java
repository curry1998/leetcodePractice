package com.boshrong.leetcode.滑动窗口;

import javafx.scene.chart.Chart;

import java.util.HashMap;

public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String a = new String("tmmzuxt");
        int i = lengthOfLongestSubstring(a);
        System.out.println(i);
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;

        int left = 0,res = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        //思想上错误没有考虑一个环节
       for(int right=0;right<s.length();right++){
           if(hashMap.containsKey(s.charAt(right))){
               left=Math.max(left,hashMap.get(s.charAt(right))+1);
           }
           hashMap.put(s.charAt(right),right);
           res=Math.max(res,right-left+1);
       }
        return res;
    }

}



