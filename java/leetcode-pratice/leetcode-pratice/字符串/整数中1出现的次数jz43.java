package com.boshrong.leetcode.字符串;

public class 整数中1出现的次数jz43 {
    public int countDigitOne(int n) {
        int res = 0;
        while(n>=1){
            String s = String.valueOf(n);
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '1'){
                    res++;
                }
            }
            n--;
        }
        return res;
    }
}
