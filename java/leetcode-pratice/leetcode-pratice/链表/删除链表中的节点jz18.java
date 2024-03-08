package com.boshrong.leetcode.链表;


import com.boshrong.leetcode.链表.ListNode;

public class 删除链表中的节点jz18 {

    public ListNode deleteNode (ListNode head, int val) {

        if (head==null||head.next==null){
            return null;
        }
        if (head.val==val){
            return head.next;
        }

        // 生成两个工作指针
        ListNode listnode =new ListNode(0);
        ListNode PreNode=new ListNode(0);
        listnode=head.next;
        PreNode=head;


        while(listnode!=null){
            if(listnode.val==val){
                //进行删除
                PreNode.next=listnode.next;
                break;
            }
            PreNode=listnode;
            listnode=listnode.next;
        }
        return head;
    }
}
