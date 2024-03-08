package com.boshrong.leetcode.字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 串联所有单词的子串 {
    public static void main(String[] args) {
        findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",new String[]{"fooo","barr","wing","ding","wing"});
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        int lens=words.length;
        int stringLens=words[0].length();
        if(lens==0){
            return null;
        }
        // 使用一个hashmao 记录words 中每个单词出现的次数
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (String word:words) {
           if(!wordMap.containsKey(word)){
               wordMap.put(word,1);
           }else{
               wordMap.replace(word,wordMap.get(word)+1);
           }
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            int windows=lens*stringLens;
            if(i+windows>s.length()){
                return result;
            }
            result.add(i);

            for(int k=i;k<i+windows;k+=stringLens){
                String window=s.substring(k,k+stringLens);
                //查看window 是否在hashmap 中
                if(!wordMap.containsKey(window)||wordMap.get(window)==0){
                    result.remove(result.size()-1);
                    break;
                }else{
                    wordMap.replace(window,wordMap.get(window)-1);
                    continue;
                }
            }

            wordMap.clear();
            for (String word:words) {
                if(!wordMap.containsKey(word)){
                    wordMap.put(word,1);
                }else{
                    wordMap.replace(word,wordMap.get(word)+1);
                }
            }

        }
        return result;
    }
}
