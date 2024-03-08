package com.boshrong.leetcode.dfs;

import java.util.ArrayList;

public class 字符串的排列jz38 {

    public static void main(String[] args) {
        Permutation("ABC");
    }
    // temp 保存中间结果， list 保存剩余的字符
    static void dfs(String temp,ArrayList<Character> list,ArrayList<String> result){
        int len=list.size();
        if(len==0){
            if (!result.contains(temp)) {
                result.add(temp);
            }
            return;
        }
        for(int i=0;i<len;i++){
            //重新new 一段区域,因为list的在这段代码中的值不能修改
            ArrayList<Character> characters = new ArrayList<>(list);
            Character remove = characters.remove(i);
            dfs(temp+list.get(i),characters,result);
        }

    }


    public static ArrayList<String> Permutation(String str) {
        int lens=str.length();
        ArrayList<String> result = new ArrayList<>();
        if(lens<0){
            return result;
        }
        // 用一个char 类型的数组便于操作
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0;i<lens;i++){
            list.add(str.charAt(i));
        }
        dfs("",list,result);
        return result;
    }
}
