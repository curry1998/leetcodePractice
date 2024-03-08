package com.boshrong.leetcode.队列栈;

import java.util.ArrayDeque;

public class 每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        // 思路:  求后面第一个比它大的元素， 单调栈（单调递减栈），存储下标
        int lens = temperatures.length;
        ArrayDeque<Integer> stack =new ArrayDeque<>();
        int [] res = new int[lens];
        for(int i=0;i<lens;i++){
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]){
                int t=stack.pop();
                res[t]=i-t;
            }
            stack.push(i);
        }
        return res;
    }
}
