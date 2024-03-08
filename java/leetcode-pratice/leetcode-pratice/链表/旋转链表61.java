package com.boshrong.leetcode.链表;

public class 旋转链表61 {

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        head.next=listNode;
        listNode.next=listNode1;
        rotateRight(head,2);
    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return null;
        }

        ListNode vhead=new ListNode(0);
        vhead.next=head;
        int lens=1;
        ListNode work=head;
        while(work.next!=null){
            lens++;
            work=work.next;
        }
        // 解决k 大于长度问题
        k=k%lens;
        // 统计长度
        ListNode rear=head;
        ListNode pre=head;
        while(k!=0){
            rear=rear.next;
            k--;
        }
        while(rear.next!=null){
            rear=rear.next;
            pre=pre.next;
        }
        //直接差额插入到

        rear.next=vhead.next;
        vhead.next=pre.next;
        pre.next=null;
        return vhead.next;

    }
}
