package com.boshrong.leetcode.队列栈;

import java.util.ArrayList;
import java.util.LinkedList;

public class 滑动窗口的最大值优化 {
    public static void main(String[] args) {
      maxInWindows(new int[]{2,3,4,2,6,2,5,1},3);
    }
    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        //使用双端队列进行解题
        ArrayList<Integer> res = new ArrayList<>();
        int lens=num.length;
        if(lens==0|| lens<size|| size==0){
            return res;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        // 队列存储相应值的下标
        for(int i=0;i<num.length;i++){
            if(!queue.isEmpty() && (i-queue.peek())==size){
                queue.pop();

            }
            if (!queue.isEmpty() && num[queue.getLast()]<num[i]){
                queue.removeLast();
                while(!queue.isEmpty()&& num[queue.getLast()]<num[i]){
                    queue.removeLast();
                }
            }
            queue.add(i);
            if(i>=size-1 ){
                res.add(num[queue.peek()]);
            }
        }
        return res;
    }
}
