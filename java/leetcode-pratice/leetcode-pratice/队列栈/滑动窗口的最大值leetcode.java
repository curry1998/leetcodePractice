package com.boshrong.leetcode.队列栈;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 滑动窗口的最大值leetcode {
    public int[] maxSlidingWindow(int[] num, int size) {
        // 思路: 感觉类似与单调栈，单调递减栈，但这里使用队列也可以
        ArrayList<Integer> res = new ArrayList<>();
        int lens = num.length;
        if(lens == 0 || lens < size || size == 0){
            return new int[]{};
        }

        LinkedList<Integer> queue = new LinkedList<>();
        // 队列存储相应值的下标
        for(int i=0;i<num.length;i++){

            if(!queue.isEmpty() && (i-queue.peek())==size){
                queue.pop();
            }
            if (!queue.isEmpty() && num[queue.getLast()] < num[i]){
                queue.removeLast();
                while(!queue.isEmpty() && num[queue.getLast()] < num[i]){
                    queue.removeLast();
                }
            }
            queue.add(i);
            if(i >= size-1){
                res.add(num[queue.peek()]);
            }
        }
        int n = res.size();
        int [] tmpRes = new int [n];
        for(int i = 0; i< n; i++){
            tmpRes[i] = res.get(i);
        }
        return tmpRes;
    }
}
