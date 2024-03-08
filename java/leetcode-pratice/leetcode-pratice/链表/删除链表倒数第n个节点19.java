package com.boshrong.leetcode.链表;

public class 删除链表倒数第n个节点19 {
    public static void main(String[] args) {

    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        // 快慢指针使其找到倒数第n个节点
        if(head==null||n<0){
            return null;
        }
        //创建一个虚拟头节点
        ListNode listNode = new ListNode(0);
        listNode.next=head;
        ListNode leftCurrent=listNode.next;
        ListNode rightCurrent=listNode.next;
        ListNode preNode=listNode;
        int right=0;
        while (right!=n){
//            if(rightCurrent==null)
//                return null;
            rightCurrent=rightCurrent.next;
            right++;
        }

        while(rightCurrent!=null){
            rightCurrent=rightCurrent.next;
            preNode=leftCurrent;
            leftCurrent=leftCurrent.next;

        }
        // 删除
        preNode.next=leftCurrent.next;

        return listNode.next;
    }
}
