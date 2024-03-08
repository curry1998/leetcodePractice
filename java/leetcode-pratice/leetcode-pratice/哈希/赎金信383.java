package com.boshrong.leetcode.哈希;

public class 赎金信383 {
    // 用数组当作hash 的案例
    public boolean canConstruct(String ransomNote, String magazine) {
        // 思想映射到两个数组，两个数组做比较
        int n = ransomNote.length();
        int m = magazine.length();
        int [] match = new int [26];
        int [] window = new int [26];
        char [] charsRand = ransomNote.toCharArray();
        char [] charsMag = magazine.toCharArray();
        for(int i =0;i<n;i++){
            match[charsRand[i]-'a']++;
        }
        for(int i =0;i<m;i++){
            window[charsMag[i]-'a']++;
        }
        for(int i=0;i<26;i++){
            if(match[i]!=0 && match[i]>window[i]){
                return false;
            }
        }
        return true;
    }
}
