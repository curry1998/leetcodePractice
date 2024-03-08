package com.boshrong.leetcode.链表;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class 链表中环的入口节点jz22 {


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);

        listNode.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=listNode4;
        listNode4.next=listNode2;
        EntryNodeOfLoop(listNode);
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead==null)
            return null;
        ListNode listNode = new ListNode(0);
        listNode=pHead;
        Set<ListNode> set = new HashSet<>();
        while(listNode!=null){
            if (!set.contains(listNode)){
                set.add(listNode);
            }else{
                return listNode;
            }
            listNode=listNode.next;
        }

        return null;

    }
}
