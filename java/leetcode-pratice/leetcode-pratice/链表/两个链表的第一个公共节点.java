package com.boshrong.leetcode.链表;

public class 两个链表的第一个公共节点 {
    // 思想: 两个工作节点，不断的去别人的轨迹中去试探，如果能重合一定会相遇。
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode work1 = pHead1;
        ListNode work2 = pHead2;
        while(work1 != work2){
            work1 = work1 == null ? pHead2 : work1.next;
            work2 = work2 == null ? pHead1 : work2.next;
        }
        return work1;
    }
}
