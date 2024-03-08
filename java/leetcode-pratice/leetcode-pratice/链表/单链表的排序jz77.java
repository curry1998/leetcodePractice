package com.boshrong.leetcode.链表;

public class 单链表的排序jz77 {

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(3);
        head.next=listNode;
        listNode.next=listNode1;
        listNode1.next=listNode2;
        sortList(head);
    }
    public static ListNode sortList(ListNode head) {

        if(head==null){
            return null;
        }
        //新增一个虚拟头部
        ListNode vheader = new ListNode(0);
        ListNode p=head;
        ListNode q=vheader;
        ListNode r=p;

        while(p!=null){
            r=p.next;
            p.next=null;
            //找到p 结点要插入的位置
            while(q.next!=null&& q.next.val<p.val){
                q=q.next;
            }
            //找到了p 要插入的位置，q为前驱，进行插入
            p.next=q.next;
            q.next=p;
            // q重新指向头
            q=vheader;
            p=r;
        }
        return vheader.next;
    }
}
