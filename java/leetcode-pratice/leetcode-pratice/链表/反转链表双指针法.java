package com.boshrong.leetcode.链表;

public class 反转链表双指针法 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode next =head;
        ListNode pre = null;
        while(cur!=null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur =next;
        }
        return pre;
    }
}
