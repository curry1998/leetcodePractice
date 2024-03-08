package com.boshrong.leetcode.队列栈;

import java.util.ArrayDeque;
import java.util.Deque;

public class 单调栈柱状图中最大矩形84 {
    public static void main(String[] args) {
        largestRectangleArea(new int[]{2,1,5,6,2,3});
    }

    public static int largestRectangleArea(int[] heights) {

        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        // 为了方便操作进行左移,栈里面存放的是第几个元素
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }
        for (int i = 0; i < new_heights.length; i++) {
            // 出栈时，说明这个新元素是出栈元素向后找第一个比其小的元素
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                int l = stack.peek();
                int r = i;
                res = Math.max(res, (r - l - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }
}
