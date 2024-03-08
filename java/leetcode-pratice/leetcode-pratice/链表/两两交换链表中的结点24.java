package com.boshrong.leetcode.链表;



public class 两两交换链表中的结点24 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        listNode.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        swapPairs(listNode);
    }
    public static ListNode swapPairs(ListNode head) {
        if(head==null){
            return null;
        }
        //定义一个虚拟头部
        ListNode vHead=new ListNode(0);
        vHead.next=head;
        // 三个工作结点
        ListNode preNode=vHead;
        ListNode work=head;
        ListNode nodeNext=work.next;
        while(nodeNext!=null){
            //进行插入
            work.next=null;
            work.next=nodeNext.next;
            nodeNext.next=work;
            preNode.next=nodeNext;
            preNode=work;
            //向后走
            if(work.next!=null){
                work=work.next;
            }else{
                break;
            }
            nodeNext=work.next;
        }
        return vHead.next;
    }
}
