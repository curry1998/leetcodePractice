package com.boshrong.leetcode.队列栈;

import java.util.ArrayDeque;

public class 接雨水单调栈 {
    public int trap(int[] height) {
        // 双指针是用列来计算，单调栈使用的是按照行方向来计算雨水的。
        // 发现添加的柱子高度大于栈头元素了，此时就出现凹槽了，栈头元素就是凹槽底部的柱子，栈头第二个元素就是凹槽左边的柱子，而添加的元素就是凹槽右边的柱子。
        // 那么雨水高度是 min(凹槽左边高度, 凹槽右边高度) - 凹槽底部高度，代码为：int h = min(height[st.top()], height[i]) - height[mid];
        //雨水的宽度是 凹槽右边的下标 - 凹槽左边的下标 - 1（因为只求中间宽度），代码为：int w = i - st.top() - 1 ;
        // 单调栈实现,单调递减栈, 存下标
        int n = height.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        int res = 0;
        for(int i = 1; i < n; i++){
            while(!stack.isEmpty() && height[stack.peek()] <= height[i]){
                int pos = stack.pop();
                if(!stack.isEmpty())
                    res += (Math.min(height[stack.peek()], height[i])- height[pos])*(i -stack.peek()- 1);
            }
            stack.push(i);
        }
        return res;
    }
}

