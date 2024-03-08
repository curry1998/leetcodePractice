package com.boshrong.leetcode.链表;

import lombok.val;

public class 删除链表中的节点237 {
    public void deleteNode(ListNode node) {
        //删除特定节点
        if(node==null){
            return;
        }
        node.val=node.next.val;
        node.next=node.next.next;
    }
}
