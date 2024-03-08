package com.boshrong.leetcode.队列栈;

import java.util.Stack;

public class 栈的压入弹出序列jz31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int lens=pushA.length;
        int index=0;
        for(int i=0;i<lens;i++){
            if(pushA[i]!=popA[index]){
                stack.push(pushA[i]);
                continue;
            }else{
                index++;
                while(index<lens && !stack.empty() && popA[index]==stack.peek()){
                    stack.pop();
                    index++;
                }
            }

        }
        return stack.empty();
    }
}
