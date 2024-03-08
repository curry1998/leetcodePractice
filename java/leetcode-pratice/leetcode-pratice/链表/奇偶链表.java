package com.boshrong.leetcode.链表;

public class 奇偶链表 {
    public ListNode oddEvenList(ListNode head) {
        if(head ==null){
            return null;
        }
        // head 是奇数节点的头节点，rear 奇数的尾节点
        // evenHead 偶数的头节点,交替赋值
        ListNode vhead = new ListNode(0);
        vhead.next = head;
        ListNode rear = head;
        ListNode evenHead = head.next;
        ListNode work = evenHead;
        while(rear!=null && work!=null){
            rear.next = work.next;
            if(rear.next ==null){
                break;
            }
            work.next = rear.next.next;
            rear = rear.next;
            work = work.next;
        }
        rear.next = evenHead;
        return vhead.next;
    }
}
