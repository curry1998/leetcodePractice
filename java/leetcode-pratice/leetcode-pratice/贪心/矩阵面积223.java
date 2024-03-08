package com.boshrong.leetcode.贪心;

public class 矩阵面积223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        // 总面积是 两个矩形的面积 减去重叠部分的面积
        int area1 = (ax2 - ax1) * (ay2 - ay1);
        int area2 = (bx2 - bx1) * (by2 - by1);
        // 判断是否有重叠
        if((ax2 < bx1) || (bx2 < ax1) || (by2 < ay1) || (by1 > ay2)){
            // 无重叠
            return area1 + area2;
        }
        int a2x = Math.min(ax2, bx2);
        int a2y = Math.min(ay2, by2);
        int a1x = Math.max(ax1, bx1);
        int a1y = Math.max(ay1, by1);
        int ovridarea = (a2x -a1x) * (a2y - a1y);
        return area1 + area2 - ovridarea;

    }
}
