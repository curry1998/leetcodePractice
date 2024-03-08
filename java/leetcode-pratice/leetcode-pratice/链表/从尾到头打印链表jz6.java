package com.boshrong.leetcode.链表;

import java.util.ArrayList;
import java.util.Stack;

public class 从尾到头打印链表jz6 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<ListNode> stack=new Stack<ListNode>();
        ArrayList<Integer> result=new ArrayList<>();
        ListNode temp=listNode;
        while (temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        while (!stack.empty()){
            result.add(stack.pop().val);
        }
        return result;

    }
}
