package com.boshrong.leetcode.哈希;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class 数组中只出现一次的两个数字 {
}

class Solution9 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        if(array.length==0)
            return new int[0];
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=0;i<array.length;i++){
            if(map.containsKey(array[i])){
                map.remove(array[i]);
                continue;
            }else{
                map.put(array[i],1);
            }
        }
        for (Integer key:map.keySet()){
            list.add(key);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int[] ints = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ints[i]=list.get(i);
        }
        return ints;
    }
}
