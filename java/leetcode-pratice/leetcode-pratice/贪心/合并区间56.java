package com.boshrong.leetcode.贪心;

import java.util.Arrays;
import java.util.Comparator;

public class 合并区间56 {
    public int[][] merge(int[][] intervals) {
        int lens=intervals.length;
        Arrays.sort(intervals,(o1,o2)->o1[0]-o2[0]);
        // 构建一个结果集
        int [][] res=new int[lens][2];
        //结果集的索引
        int idx=-1;
        for(int [] interval : intervals){
            if(idx==-1 || interval[0]>res[idx][1]){
                //遍历的第一个元素大于结果集最后一个元素，没有重叠,结果集增加
                res[++idx]=interval;
                continue;
            }
            if(interval[0]<=res[idx][1]){
                res[idx][1]=Math.max(interval[1],res[idx][1]);
            }
        }
        return Arrays.copyOf(res,idx+1);
    }
}
