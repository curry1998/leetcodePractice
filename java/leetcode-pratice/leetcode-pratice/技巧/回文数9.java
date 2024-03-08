package com.boshrong.leetcode.技巧;

public class 回文数9 {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        String s = String.valueOf(x);
        // java 字符串翻转
        String s1 = new StringBuffer(s).reverse().toString();
        return s.equals(s1);
    }
}
