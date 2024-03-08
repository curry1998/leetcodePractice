package com.boshrong.leetcode.链表;

public class k个一组翻转链表25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null ){
            return head;
        }
        int lens=0;
        ListNode work=head;
        while(work!=null){
            work=work.next;
            lens++;
        }
        work=head;
        // 要翻转d 段
        int d=lens/k;
        // 定义一个虚拟头部
        ListNode vHead = new ListNode(0);

        //之前段的最后一个节点
        ListNode preLastNode = vHead;
        ListNode preLastNodeNext=vHead;
        //两个工作节点
        ListNode nodeNext=work.next;
        while(d!=0){
            int num=0;
            preLastNodeNext=work;
            while(num!=k&& work!=null){
                //使用头插法进行翻转
                nodeNext=work.next;
                work.next=null;
                work.next=preLastNode.next;
                preLastNode.next=work;
                work=nodeNext;
                num++;
            }
            preLastNode=preLastNodeNext;
            d--;
        }
        //将不翻转的连接到翻转后的链表后面
        preLastNodeNext.next=nodeNext;
        return vHead.next;
    }
}
