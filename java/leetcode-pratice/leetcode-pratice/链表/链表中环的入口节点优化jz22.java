package com.boshrong.leetcode.链表;



public class 链表中环的入口节点优化jz22 {
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
       if(pHead==null || pHead.next==null){
           return null;
       }
       ListNode slow=pHead;
       ListNode fast=pHead;

       while(fast!=null){

           if(fast.next==null ||fast==null){
               return null;
           }else{
               fast=fast.next;
           }
           fast=fast.next;

           slow=slow.next;
           if(slow==fast){
               break;
           }
       }
       if(fast==null){
           return null;
       }
       slow=pHead;
       while(slow!=fast){
           slow=slow.next;
           fast=fast.next;
       }
       return slow;
    }
}
