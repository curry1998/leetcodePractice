package com.boshrong.leetcode.队列栈;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class 最小的k个树leetcode {
    public int[] getLeastNumbers(int[] arr, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        int lens = arr.length;
        if(lens<k || k == 0){
            return new int[]{};
        }
        // 最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)->{
            return o2 - o1;
        });

        for(int i = 0; i < lens; i++){
            if(queue.size() < k){
                queue.add(arr[i]);
                continue;
            }
            if(queue.size() == k){
                if(queue.peek() <= arr[i]){
                    continue;
                }else{
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }

        for(int i=0;i<k;i++){
            Integer poll = queue.poll();
            res.add(poll);
        }
        Collections.reverse(res);
        int[] ints = new int[res.size()];
        for(int i = 0;i< res.size(); i++){
            ints[i] = res.get(i);
        }
        return ints;
    }
}
