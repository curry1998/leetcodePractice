package com.boshrong.leetcode.链表;

public class 反转链表jz24 {

    public ListNode ReverseList(ListNode head) {
        ListNode newHead = new ListNode(0);
        ListNode work=head;
        while(head!=null){
            work=head.next;
            // 头插法进行插入
            head.next=newHead.next;
            newHead.next=head;
            head=work;
        }

        return newHead.next;
    }
}
