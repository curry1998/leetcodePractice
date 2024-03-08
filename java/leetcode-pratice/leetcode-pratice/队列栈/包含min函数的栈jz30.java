package com.boshrong.leetcode.队列栈;

import java.util.ArrayDeque;

public class 包含min函数的栈jz30 {
    private ArrayDeque<Integer> stack;
    private ArrayDeque<Integer> min_stack;

    public void MinStack() {
        this.stack=new ArrayDeque<>();
        this.min_stack=new ArrayDeque<>();
    }

    public void push(int x) {
        this.stack.push(x);
        if(!min_stack.isEmpty()){
            if(x<=min_stack.peek()){
                min_stack.push(x);
            }
        }else{
            min_stack.push(x);
        }
    }

    public void pop() {
        if(!stack.isEmpty()) {
            int pop = stack.pop();
            if(pop == min_stack.peek()){
                min_stack.pop();
            }
        }
    }

    public int top() {
        if(!stack.isEmpty()) {
            return stack.peek();
        }else{
            return -1;
        }
    }

    public int min() {
        if(!stack.isEmpty()){
            return min_stack.peek();
        }else{
            return -1;
        }
    }
}
