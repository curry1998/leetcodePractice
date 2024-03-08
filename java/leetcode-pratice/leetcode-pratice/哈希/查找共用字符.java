package com.boshrong.leetcode.哈希;

import java.util.ArrayList;
import java.util.List;

public class 查找共用字符 {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        int [][] hash = new int[n][26];
        List<String> res = new ArrayList<>();
        for(int i =0;i<n;i++){
            char [] charWords = words[i].toCharArray();
            for(int j =0;j<charWords.length;j++){
                hash[i][charWords[j]-'a']++;
            }
        }

        for(int i=0;i<26;i++){
            int count = Integer.MAX_VALUE;
            boolean flag = true;
            for(int j = 0;j < n;j++){
                if(hash[j][i]==0){
                    flag =false;
                    break;
                }
                if(hash[j][i]<count){
                    count = hash[j][i];
                }
            }
            if(flag){
                for(int k=1;k<=count;k++){
                    //System.out.println(i);
                    char c = (char)(i+'a');
                    res.add(String.valueOf(c));
                }

            }
        }
        return res;
    }
}
