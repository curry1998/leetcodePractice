package com.boshrong.leetcode.字符串;

import java.util.ArrayList;
import java.util.List;

public class 字母异位词分组49 {
    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        // 将这些字符串都先放到二维数组中
        // 遍历字符串与二维数组中的进行比较。
        int lens=strs.length;
        int [][] hash=new int[lens][26];
        boolean [] visted=new boolean[lens];
        List<List<String>> res =new ArrayList<>();
        for(int i=0;i<lens;i++){
            for(int j=0;j<strs[i].length();j++){
                hash[i][strs[i].charAt(j)-'a']=hash[i][strs[i].charAt(j)-'a']+1;
            }
        }
        for(int i=0;i<lens;i++){
            if(visted[i]==true){
                continue;
            }
            String tmp =strs[i];
            visted[i]=true;
            ArrayList<String> list=new ArrayList<>();
            list.add(tmp);
            for(int j=i+1;j<lens;j++){
                if(visted[j]==true){
                    continue;
                }
                if(strs[i].length()!=strs[j].length()){
                    continue;
                }
                boolean flag=true;
                for(int k=0;k<strs[i].length();k++){
                    if(hash[i][strs[i].charAt(k)-'a']!=hash[j][strs[i].charAt(k)-'a']){
                        flag=false;
                        break;
                    }
                    continue;
                }
                if(flag){
                    list.add(strs[j]);
                    visted[j]=true;
                }
            }
            res.add(list);

        }
        return res;
    }
}
