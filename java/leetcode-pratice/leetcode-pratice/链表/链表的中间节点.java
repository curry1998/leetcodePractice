package com.boshrong.leetcode.链表;

public class 链表的中间节点 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow =slow.next;
        }
        return slow;
    }
}
