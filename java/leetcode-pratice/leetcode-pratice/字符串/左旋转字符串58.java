package com.boshrong.leetcode.字符串;

public class 左旋转字符串58 {


    public String reverseLeftWords(String s, int n) {
        int lens=s.length();
        if(lens<1|| n>lens){
            return "";
        }
        String substring = s.substring(0, n);
        String substring2=s.substring(n,lens);
        substring2+=substring;
        return substring2;
    }
}
