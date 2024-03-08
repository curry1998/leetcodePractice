package com.boshrong.leetcode.排序类似;

import java.util.*;

public class 数据流的中位数jz41 {

    //定义一个数组
    ArrayList<Integer> array = new ArrayList<>();
    public void Insert(Integer num) {
        //在每次插入的时候进行排序
        array.add(num);
        Collections.sort(array);

    }
    public Double GetMedian() {
        int lens=array.size();
        int mid=lens/2;
        if(lens<1){
            return 0.0;
        }
        if(lens%2==0){
            return (array.get(mid-1)+array.get(mid))/2.0;
        }else{
            return array.get(lens/2).doubleValue();
        }
    }
}
