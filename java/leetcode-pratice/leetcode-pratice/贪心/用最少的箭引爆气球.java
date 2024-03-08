package com.boshrong.leetcode.贪心;

import java.util.Arrays;

public class 用最少的箭引爆气球 {

    public int findMinArrowShots(int[][] points) {
        //求重叠区间的个数 贪心，先按照左区间进行排序
        // end 表示已重合的区间的最小结尾。当end<points[i][0] 说明区间不重叠，需要一把箭，删除之前的重合区间，并更新end。
        // 当end>=points[i][0] 时，说明end和现有区间重合，选择短的区间作为end。
        Arrays.sort(points,(o1, o2)->{
            //return o1[0]-o2[0];
            return Integer.compare(o1[0],o2[0]);
        });
        int end =points[0][1];
        int res = 1;
        int n = points.length;
        for(int i=1;i<n;i++){
            if(end<points[i][0]){
                res++;
                end = points[i][1];
            }else{
                end = Math.min(points[i][1],end);
            }
        }
        return res;
    }
}
