package com.boshrong.leetcode.字符串;

public class 实现strStr28 {
    public int strStr(String haystack, String needle) {
        // 字符串匹配类型题目 使用kmp 获取到next 数组， 遍历haystack 与next 数组进行匹配
        int n = haystack.length();
        int m = needle.length();
        if(m < 1){
            return -1;
        }
        int [] next = new int [m];
        getNext(next, needle);
        int j = -1;
        //遍历haystack 数组
        for(int i = 0;i < n; i++){
            while(j >= 0 && haystack.charAt(i) != needle.charAt(j+1)){
                j = next[j];
            }
            if(haystack.charAt(i) == needle.charAt(j+1)){
                j++;
            }
            if( j == m - 1){
                return i-(m-1);
            }
        }
        return -1;
    }
    // 获取s 的next数组
    public void getNext(int [] next , String s){
        int j = -1;
        next[0] = -1;
        char [] words = s.toCharArray();
        for(int i = 1;i < s.length(); i++){
            while(j >= 0 && words[i] != words[j+1]){
                j = next[j];
            }
            if(words[i] == words[j+1]){
                j++;
            }
            next[i] = j;
        }
    }
}
