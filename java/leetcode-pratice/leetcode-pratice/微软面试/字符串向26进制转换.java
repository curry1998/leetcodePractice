package com.boshrong.leetcode.微软面试;

public class 字符串向26进制转换 {
    public int titleToNumber(String columnTitle) {
        int lens=columnTitle.length();
        int res=0;
        int value=1;
        for(int i=lens-1;i>=0;i--){
            int s=columnTitle.charAt(i)-'A'+1;
            res+=s*value;
            value*=26;
        }
        return res;
    }
}
