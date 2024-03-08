package com.boshrong.leetcode.队列栈;

import java.util.PriorityQueue;

public class 丑数49 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(1600));

    }

    // 不能直接采取for 循环，边循环边判断 for 循环的界限是不知道的
    // 思想就是 x 是丑数，则 2x 3x 5x 为丑数，将其放入到优先队列中，每次取去一个 i 放入2i,3i,5i,但也会产生一个问题，就是会重复 需进行判断
    // 优先队列采用long，防止int 溢出。
    // 也可以采用最小堆，
    public static int nthUglyNumber(int n) {
        if(n<1){
            return 0;
        }
        PriorityQueue<Long> integers = new PriorityQueue<>();
        integers.add(1L);
        int count=1;
        while(count<n && !integers.isEmpty()){
            long value=integers.poll();

            if(!integers.contains(2*value)){
                integers.add(2*value);
            }
            if(!integers.contains(3*value)){
                integers.add(3*value);
            }
            if(!integers.contains(5*value)){
                integers.add(5*value);
            }
            count++;
        }
        long poll = integers.poll();
        return (int)poll;
    }
}
