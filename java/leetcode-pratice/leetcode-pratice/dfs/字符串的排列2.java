package com.boshrong.leetcode.dfs;

import java.util.ArrayList;

public class 字符串的排列2 {
    int lens;
    public void dfs(String temp,ArrayList list,ArrayList res){
        if(temp.length()==lens){
            if(!res.contains(temp)) {
                res.add(temp);
            }
        }
        for(int i=0;i<list.size();i++){
            ArrayList arrayList = new ArrayList<>(list);
            Character remove = (Character) arrayList.remove(i);
            dfs(temp+remove,arrayList,res);
            // list 没有进入下层递归是不变的，所以不用添加
        }
    }
    public String[] permutation(String s) {
        lens=s.length();
        ArrayList<String> res = new ArrayList<>();
        if(lens==0){
            return new String[]{};
        }
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0;i<lens;i++){
            list.add(s.charAt(i));
        }
        dfs("",list,res);
        String[] strings = new String[res.size()];
        for(int i=0;i<res.size();i++){
            strings[i]=res.get(i);
        }
        return strings;

    }
}
