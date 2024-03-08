package com.boshrong.leetcode.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 分割回文子串 {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        int lens= s.length();
        this.res=new ArrayList<>();
        LinkedList<String> path=new LinkedList<>();
        dfs(s,0,path);
        return res;
    }

    // startIndex 横向， 递归纵向
    public void dfs(String s, int startIndex, LinkedList<String> path){
        // 递归结束判断
        if(startIndex>=s.length()){
            return;
        }

        //结果保存
        if(startIndex==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i=startIndex;i<s.length();i++){
            // statIndex 到i 进行切割
            if(!isCorrectString(s,startIndex,i)){
                continue;
            }
            // substring 都是小写
            path.add(s.substring(startIndex,i+1));
            dfs(s,i+1,path);
            path.removeLast();
        }
    }
    public boolean isCorrectString(String s,int l, int r){
        while(l<r && s.charAt(l)==s.charAt(r)){
            l++;
            r--;
        }
        if(l<r){
            return false;
        }
        return true;
    }
}
