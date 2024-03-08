package com.boshrong.leetcode.字符串;

public class 重复的子字符串 {
    public boolean repeatedSubstringPattern(String s) {
        // 求next 数组 表示s 的最长公共前后缀
        int n = s.length();
        //使其右移一位
        int [] next = new int [n];
        getNext(next,s);
        if(next[n-1] != -1 && n %(n - (next[n-1] + 1)) == 0 ){
            return true;
        }
        return false;
    }
    public void getNext(int [] next, String s){
        // j 指向前缀的末尾， i 指向后缀末尾（注意是一段的字符串 0~i 的字符串）
        int j = -1;
        next[0] = -1;
        char [] words = s.toCharArray();
        // i 从1 开始，因为从0位置处没有前后缀
        for(int i = 1; i < s.length(); i++){
            while(j >= 0 && words[j+1] != words[i]){
                j = next[j];
            }
            if(words[j+1] == words[i]){
                j++;
            }
            //j 初始化为-1, 所以没有相同的前后缀则为-1
            next[i] = j;
        }
    }
}
