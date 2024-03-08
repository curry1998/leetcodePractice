package com.boshrong.leetcode.滑动窗口;

import java.util.*;

public class 找到字符串中所有字母异位词 {

    public  List<Integer> findAnagrams(String s, String p) {
        //滑动窗口 使用一个数组保存要匹配的窗口
        // window 要滑动的窗口
        int n = s.length();
        int m = p.length();
        // 匹配的窗口
        int [] needed = new int[26];
        // 滑动的窗口
        int  [] window = new int[26];
        char [] swords = s.toCharArray();
        char [] pwords = p.toCharArray();
        for(int i=0;i<m;i++){
            needed[pwords[i]-'a']++;
        }

        int l=0,r=0;
        List<Integer> res = new ArrayList<>();
        while(r<n){
            window[swords[r]-'a']++;
            //因为是判断是否相等，不用if
            if(r-l ==m-1){
                if(checkwindows(needed,window)) {
                    res.add(l);
                }
                window[swords[l]-'a']--;
                l++;
            }
            r++;
        }
        return res;
    }
    public  boolean checkwindows(int [] needed,int[] window){
        for(int i=0;i<26;i++){
            if(needed[i]!=window[i]){
                return false;
            }
        }
        return true;
    }
}
