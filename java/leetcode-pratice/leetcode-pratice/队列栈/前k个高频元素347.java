package com.boshrong.leetcode.队列栈;

import org.apache.tomcat.jni.Mmap;

import java.util.*;

public class 前k个高频元素347 {
    public static void main(String[] args) {
        topKFrequent(new int[]{1,1,1,2,2,3,6,6,6},2);
    }

    public static  int[] topKFrequent(int[] nums, int k) {
        int lens=nums.length;
        if(lens<1 ||lens<k ){
            return new int[]{};
        }
        // 集合只能使用包装类型,使用hashmap 统计每个字符出现的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<lens;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }else{
                map.replace(nums[i],map.get(nums[i])+1);
            }
        }
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            // 创建一个最小堆
            @Override
            public int compare(int[] o1, int[] o2) {
                // 字典升序 o1[1]-o2[1] 默认是升序, o2[1]-o2[1]为降序
                return o2[1]-o1[1];
            }
        });

        for(Map.Entry<Integer,Integer> keyValue:map.entrySet()){
            if(priorityQueue.size()<k){
                priorityQueue.add(new int []{keyValue.getKey(),keyValue.getValue()});
                continue;
            }
            if(priorityQueue.size()==k){
                if(priorityQueue.peek()[1]>keyValue.getValue()){
                    continue;
                }else{
                    priorityQueue.poll();
                    priorityQueue.add(new int[]{keyValue.getKey(),keyValue.getValue()});
                }
            }
        }
        // 返回最终结果
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            int[] num = priorityQueue.poll();
            res[i]=num[0];
        }
        return res;
    }
}
