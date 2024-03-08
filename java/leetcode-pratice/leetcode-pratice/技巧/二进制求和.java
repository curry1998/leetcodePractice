package com.boshrong.leetcode.技巧;

import org.apache.logging.log4j.util.Strings;

public class 二进制求和 {
    public String addBinary(String a, String b) {
        //思路 模拟二进制加法 为了方便，先将字符串进行翻转
        // 翻转后， 加上获取每一位的值，并加上进位。
        int len1=a.length();
        int len2=b.length();
        a=reverse(a);
        b=reverse(b);
        String res="";
        int flag=0;
        for(int i=0; i<len1 || i<len2;i++){

            int val1= i>=len1? 0 : a.charAt(i)-'0';
            int val2= i>=len2 ? 0 : b.charAt(i)-'0';
            int s=val1+val2+flag;
            //更新 进位 和 当前值
            flag=s/2;
            s=s%2;
            res+=s;
        }
        if(flag!=0){
            res+=flag;
        }
        return reverse(res);
    }
    public String reverse(String a){
        int lens=a.length();
        String res="";
        for(int i=lens-1;i>=0;i--){
            res+=a.charAt(i);
        }
        return res;
    }
}
