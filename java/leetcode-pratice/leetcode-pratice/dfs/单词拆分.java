package com.boshrong.leetcode.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 单词拆分 {

    public boolean wordBreak(String s, List<String> wordDict) {
        // dfs加记忆的保存，先实现一个不带记忆的
        // 记忆化递归
        // 记忆以 index 开头的是否在能否匹配

        HashMap<String,Boolean> map=new HashMap<>();
        for(String word: wordDict ){
            map.put(word,true);
        }
        HashMap<Integer,Boolean> mem = new HashMap<>();
        return dfs(s,0,wordDict,map,mem);
    }
    public boolean dfs(String s,int index,List<String> wordDict,HashMap<String,Boolean> map,HashMap<Integer,Boolean> mem){
        if(index == s.length()){
            return true;
        }
        if(mem.containsKey(index)){
            return mem.get(index);
        }
        for(int i=index;i<s.length();i++){
            String tmp=s.substring(index,i+1);
            // tmop在单词表中，并且剩余子串也能match
            if(map.containsKey(tmp) && dfs(s,i+1,wordDict,map,mem)){
                mem.put(index,true);
                return true;
            }else{
                mem.put(index,false);
            }
        }
        return false;
    }
}
