package com.boshrong.leetcode.链表;

public class 删除链表中重复的节点 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(3);
        listNode.next=listNode1;
        listNode1.next=listNode2;
        listNode2.next=listNode3;
        listNode3.next=null;
        deleteDuplicates(listNode);
    }
    public static ListNode deleteDuplication(ListNode pHead) {
       if(pHead==null){
           return pHead;
       }
       // 创建一个空指针newHeader,为了防止pHead 为重复元素
        ListNode newHeade = new ListNode(0);
       newHeade.next=pHead;
       //两个工作指针
        ListNode current=pHead;
        ListNode preHeade=newHeade;
        while(current!=null){
            // 找到相同元素
            if(current.next!=null && current.val==current.next.val){
                current=current.next;
                while (current.next!=null && current.val==current.next.val){
                    current=current.next;
                }
                //进行串联,这一步不要赋值 preHeader=current，要等到它不重复的时候赋值
                current=current.next;
                preHeade.next=current;

            }else{
                preHeade=current;
                current=current.next;
            }
        }
        return newHeade.next;
    }











    // 方法二
    public static ListNode deleteDuplicates(ListNode head) {

        if(head==null){
            return head;
        }
        //头结点可能会被删除，创建一个头结点
        ListNode newHead = new ListNode(0);
        newHead.next=head;
        ListNode preNode = newHead;
        ListNode workNode = head;
        while(workNode!=null){
            // 找到相同的，尽可能找最多的
            if(workNode.next!=null && workNode.val==workNode.next.val){
                workNode=workNode.next;
                while(workNode.next!=null && workNode.val==workNode.next.val){
                    workNode=workNode.next;
                }
                //进行串连
                workNode=workNode.next;
                preNode.next=workNode;
            }else{
                preNode =workNode;
                workNode=workNode.next;
            }
        }
        return newHead.next;
    }
}
