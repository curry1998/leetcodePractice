package com.boshrong.leetcode.链表;

public class 排序链表归并排序 {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        // br 的作用是将链表断成两端
        ListNode br= new ListNode(0);
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            if(fast==null ||fast.next==null){
                br = slow;
            }
            slow = slow.next;
        }
        // 返回一个已经排好序的左边和右边
        br.next=null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        ListNode vhead= new ListNode(-1);
        ListNode cur = vhead;
        while(left !=null || right!=null){
            if(((left!=null && right!=null)&&left.val<=right.val)|| (right==null && left!=null)){
                cur.next = left;
                // left 重新指向下一个节点
                left = left.next;
                cur =cur.next;
            }
            if(((left!=null && right!=null)&&left.val>right.val)|| (left==null && right!=null)){
                cur.next = right;
                // left 重新指向下一个节点
                right = right.next;
                cur =cur.next;
            }
        }
        return vhead.next;
    }

}
