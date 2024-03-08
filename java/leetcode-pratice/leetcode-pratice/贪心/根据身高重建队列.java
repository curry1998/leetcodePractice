package com.boshrong.leetcode.贪心;

import java.util.Arrays;
import java.util.LinkedList;

public class 根据身高重建队列 {
    public int[][] reconstructQueue(int[][] people) {
        // 思路 顺序是乱的，区间问题
        // 重新定义顺序 优先队列,优先队列怎么排，感觉使用优先队列用不上，得自己遍历，类似于排序
        // 这道题使用的是贪心的方法，按照身高从大到小进行排序，身高相同按下标从小到大，比较完后，按下标进行插入
        // 其不受影响
        int len1=people.length;
        Arrays.sort(people,(a, b)->{
            // 按身高从大到小
            if(a[0]!=b[0]){
                return b[0]-a[0];
            }
            return a[1]-b[1];
        });
        //对排好序的直接进行插入
        // 使用一个双端队列
        LinkedList<int[]> queue=new LinkedList<>();
        for(int[] p:people){
            // 按照第i 个下标
            queue.add(p[1],p);
        }
        return queue.toArray(new  int[len1][2]);
    }
}
