package com.boshrong.leetcode.链表;

public class 反转链表二 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 这道题反转双指针法比较简单
        // 分别指向要翻转链表的左边和右边。分别保存他们的前驱和后驱。
        // 对链表进行翻转，前驱的next 指向翻转的头节点，后驱为翻转链表左边的next
        if(left>right){
            return null;
        }
        ListNode vhead= new ListNode(0);
        vhead.next= head;
        ListNode pre = vhead;
        for(int i=1;i<left;i++){
            pre = pre.next;
        }
        ListNode leftReverse = pre.next;
        ListNode work = pre.next;
        for(int i=left;i<=right;i++){
            work = work.next;
        }
        ListNode rightReverse = work;
        ListNode back =rightReverse.next;

        // 断开
        pre.next = null;
        rightReverse.next = null;

        ListNode rev = reverse(leftReverse);
        pre.next=rev;
        leftReverse.next=back;
        return vhead.next;

    }

    public ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode next = head;
        while(head!=null){
            next = head.next;
            head.next =pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
