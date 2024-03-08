package com.boshrong.leetcode.字符串;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 字符流中第一个不重复的字符jz75 {

    // map 统计每个字符出现的次数
    // list 存储字符流
    HashMap<Character, Integer> map = new HashMap<>();
    List<Character> list=new ArrayList<>();
    void Insert(char ch)
    {
        if(map.containsKey(ch)){
            map.replace(ch,map.get(ch)+1);
        }else{
            map.put(ch,1);
        }
        list.add(ch);
    }
    //return the first appearence once char in current stringstream
    char FirstAppearingOnce()

    {
        //每插入一次就调用该函数
        char c='#';
        for(char key : list){
            if(map.get(key)==1){
                c=key;
                break;
            }
        }

        return c;
    }


}
