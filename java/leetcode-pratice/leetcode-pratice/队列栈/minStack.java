package com.boshrong.leetcode.队列栈;

import java.util.ArrayList;

public class minStack {
    ArrayList<Integer> stack;
    ArrayList<Integer> minStack;
    public minStack() {
        this.stack=new ArrayList<>();
        this.minStack=new ArrayList<>();

    }

    public void push(int val) {
        stack.add(val);
        if(minStack.size()!=0 && minStack.get(minStack.size()-1)<val){

        }else{
            minStack.add(val);
        }
    }

    public void pop() { 
        int val=stack.remove(stack.size()-1);
        if(val==minStack.get(minStack.size()-1)){
            minStack.remove(minStack.size()-1);
        }
    }

    public int top() {
        return stack.get(stack.size()-1);
    }

    public int getMin() {
        return minStack.get(minStack.size()-1);
    }
}
