package com.boshrong.leetcode.队列栈;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 最小的K个数 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int lens=input.length;
        if(lens<k || k == 0){
            return res;
        }
        // 最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1,o2)->{
            return o2 - o1;
        });

        for(int i = 0; i < lens; i++){
            if(queue.size() < k){
                queue.add(input[i]);
                continue;
            }
            if(queue.size() == k){
                if(queue.peek() <= input[i]){
                    continue;
                }else{
                    queue.poll();
                    queue.add(input[i]);
                }
            }
        }

        for(int i=0;i<k;i++){
            Integer poll = queue.poll();
            res.add(poll);
        }
        Collections.reverse(res);

        return res;
    }
}
