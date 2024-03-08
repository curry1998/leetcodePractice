package com.boshrong.leetcode.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class 字符串的排列方法二 {
    ArrayList<String> res;
    public String[] permutation(String s) {
        int n = s.length();
        res = new ArrayList<>();
        char [] chars= s.toCharArray();
        // 去重要先排序
        Arrays.sort(chars);
        LinkedList<String> path=new LinkedList<>();
        boolean [] visited = new boolean[s.length()];
        dfs(chars,path,visited);
        String [] Stringres = new String[res.size()];
        for(int i=0;i<res.size();i++){
            Stringres[i]=res.get(i);
        }
        return Stringres;
    }
    public void dfs(char[] s, LinkedList path,boolean [] visited){
    
        if(path.size() == s.length){
            res.add(String.join("",path));
            return ;
        }
        for(int i= 0;i<s.length;i++){

            if(i>0 &&visited[i-1]==false &&  s[i]==s[i-1]){
                continue;
            }
            if(visited[i]==true){
                continue;
            }

            visited[i] = true;
            path.add(String.valueOf(s[i]));
            dfs(s,path,visited);
            visited[i] = false;
            path.removeLast();
        }
    }
}
