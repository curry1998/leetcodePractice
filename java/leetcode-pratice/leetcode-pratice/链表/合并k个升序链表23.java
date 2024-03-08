package com.boshrong.leetcode.链表;

import lombok.val;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 合并k个升序链表23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int lens= lists.length;
        if(lens==0){
            return null;
        }
        //定义头结点
        ListNode head = new ListNode(0);
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });

        //队列初始化
        for(int i=0;i<lens;i++){
            if(lists[i]!=null)
                priorityQueue.add(lists[i]);
        }
        ListNode tail=head;
        while(!priorityQueue.isEmpty()){
            // 取出来
            ListNode poll = priorityQueue.poll();
            if(poll.next!=null){
                priorityQueue.add(poll.next);
            }
            //尾插法插
            tail.next=poll;
            tail=poll;

        }
        return head.next;
    }
}
