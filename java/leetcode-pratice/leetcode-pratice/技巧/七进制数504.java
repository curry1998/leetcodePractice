package com.boshrong.leetcode.技巧;

public class 七进制数504 {
    public String convertToBase7(int num) {
        // 思路: 转化为7进制。 一个整型转化为任意进制的方法。每次将该进制的个位拿出来，然后把个位去掉。
        // 拿出个位 %要转化的进制 ， 把个位去掉 /要转化的进制。
        // 先算出来的是个位，最后将字符串进行翻转即可。
        String res="";
        if(num==0){
            res+="0";
        }

        boolean isNegative=num>=0?false:true;
        num=Math.abs(num);
        while(num!=0){
            //对7取余，求出个位。
            res+=num%7;
            num=num/7;
        }

        if(isNegative){
            res+="-";
        }

        return reverse(res);
    }
    public String reverse(String s){
        int lens=s.length();
        String res="";
        for(int i=lens-1;i>=0;i--){
            res+=s.charAt(i);
        }
        return res;
    }
}
