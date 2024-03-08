package com.boshrong.leetcode.dfs;

import org.apache.logging.log4j.util.Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 电话号码的字母组合17 {

    public static void main(String[] args) {
        String ss="23";
            System.out.println(letterCombinations(ss));
    }

    public static void dfs(int begin,String digits,String [] strings,String tempStrings,List<String> result){
        if(begin==digits.length()){
            result.add(tempStrings);
            return;
        }
        int i = Integer.parseInt(String.valueOf(digits.charAt(begin)));
        int length = strings[i-1].length();
        for (int k=0;k<length;k++){
            dfs(++begin,digits,strings,tempStrings+strings[i-1].charAt(k),result);
            begin--;
        }

    }

    public static List<String> letterCombinations(String digits) {
        //用一个map 存储号码到string的对应关系
        ArrayList<String > arrayList = new ArrayList<>();
        int lens=digits.length();
        if(lens<1){
            return arrayList;
        }
        String [] strings=new String[]{" ","abc","def","ghi","jkl","mno","pqrs","tuv","xwyz"};
        dfs(0,digits,strings,"",arrayList);
        return arrayList;

    }
}
