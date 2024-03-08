package com.boshrong.leetcode.链表;

public class 移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode pre = vhead;
        ListNode work = head;
        while(work!=null){
            if(work.val==val){
                pre.next = work.next;
            }else{
                pre = work;
            }
            work = work.next;
        }
        return vhead.next;
    }
}
