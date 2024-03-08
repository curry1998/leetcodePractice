package com.boshrong.leetcode.字符串;

import java.util.HashMap;

public class 第一个只出现一次的字符jz50 {
    // 思想，使用hashmap 存储出现次数，遍历整个字符串找到第一个。
    public char firstUniqChar(String s) {
        int n = s.length();
        char [] words = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(!map.containsKey(words[i])){
                map.put(words[i], 1);
            }else{
                map.put(words[i],map.get(words[i])+1);
            }
        }
        for(int i = 0; i < n; i++){
            if(map.get(words[i]) == 1){
                return words[i];
            }
        }
        return ' ';

    }
}
