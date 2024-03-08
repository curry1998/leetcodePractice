package com.boshrong.leetcode.贪心;

import java.util.Arrays;

public class 插入区间57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        int lens=intervals.length;
        int [][] res=new int[lens+1][2];
        // res 的索引
        int idx=0;
        // 遍历的索引
        int i=0;
        //已经排好序了
        while(i<lens && intervals[i][1]<newInterval[0]){
            res[idx++]=intervals[i];
            i++;
        }
        //有重叠合并成一个,更新newInterval
        while(i<lens && intervals[i][0]<newInterval[1]){
            newInterval[0]=Math.min(newInterval[0],intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        res[idx++]=newInterval;
        while(i<lens){
            res[idx++]=intervals[i];
            i++;
        }
        return Arrays.copyOf(res,idx);
    }
}
