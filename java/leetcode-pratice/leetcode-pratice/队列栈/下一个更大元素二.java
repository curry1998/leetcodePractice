package com.boshrong.leetcode.队列栈;

import java.util.ArrayDeque;
import java.util.Arrays;

public class 下一个更大元素二 {
    public int[] nextGreaterElements(int[] nums) {
        // 思路: 循环起来了，其实本质还是单调栈 。单调递减栈
        // 模拟两边 nums, 存下标
        int n = nums.length;
        int [] res = new int [n];
        Arrays.fill(res, -1);
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n *2; i++){
            while(!stack.isEmpty() && nums[stack.peek()] < nums[i%n]){
                res[stack.peek()] = nums[i%n];
                stack.pop();
            }

            stack.push(i%n);

        }
        return res;
    }
}
