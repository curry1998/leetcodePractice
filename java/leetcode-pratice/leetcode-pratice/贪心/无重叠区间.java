package com.boshrong.leetcode.贪心;

import java.util.Arrays;

public class 无重叠区间 {
    public int eraseOverlapIntervals(int[][] intervals) {
            //思路
            //贪心算法的体现。冲突的话尽可能选择末尾比较小的，选择末尾小的，有较大的可能性，不和后面的冲突。
            //解题： 现按照左区间进行排序，排好序，看右区间，如果右区间有冲突，选择右区间小的。
            // 使用一个值保存已经满足条件的末尾。不断的去更新这个末尾值。
            int n = intervals.length;
            Arrays.sort(intervals,(o1, o2)->{
            return o1[0]-o2[0];
        });
            int res =0;
            int end =intervals[0][1];
            for(int i=1;i<n;i++){
                if(intervals[i][0]>=end){
                    // 无冲突
                    end=intervals[i][1];
                    continue;
                }else{
                    // 选择end 比较小的
                    end = Math.min(end,intervals[i][1]);
                    res++;
                }
            }
            return res;

    }

}
