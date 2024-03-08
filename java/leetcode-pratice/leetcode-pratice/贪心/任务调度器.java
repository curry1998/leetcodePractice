package com.boshrong.leetcode.贪心;

import java.util.Arrays;

public class 任务调度器 {
    // 贪心 先排个数最多的任务，在最多任务的冷却时间内插入其他任务
    // 最多任务的作为行， n+1 作为列进行计算

    public int leastInterval(char[] tasks, int n) {
        int lens = tasks.length;
        int [] array = new int[26];
        Arrays.fill(array,0);
        for(int i=0;i<lens;i++){
            array[tasks[i]-'A']++;
        }
        int max = 0;
        for(int i=0;i<26;i++){
            if(max<array[i]){
                max = array[i];
            }
        }
        int res = (max-1)*(n+1);
        for(int i=0;i<26;i++){
            if(array[i]==max){
                res++;
            }
        }
        return Math.max(res,tasks.length);
    }
}
