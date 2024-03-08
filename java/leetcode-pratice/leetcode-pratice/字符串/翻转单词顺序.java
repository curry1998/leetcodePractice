package com.boshrong.leetcode.字符串;

public class 翻转单词顺序 {
    // 牛客测试用例不完善 leetcode  a 就过不了

    public String reverseWords(String s) {
        int n = s.length();
        if( n < 1 ){
            return s;
        }
        char [] words = s.toCharArray();
        int l = n-1, r = n-1;
        String res = "";
        while(l>=0){
            while(l >= 0 && words[l] == ' '){
                l--;
            }
            r = l;
            while(l >= 0 && words[l] != ' '){
                l--;
            }
            if(l<r){
                res += s.substring(l+1,r+1);
                res += " ";
            }
        }
        //去除最后的空格
        int m = res.length()-1;
        while(m >= 0 && res.charAt(m) == ' '){
            m--;
        }
        return res.substring(0,m+1);
    }
}
