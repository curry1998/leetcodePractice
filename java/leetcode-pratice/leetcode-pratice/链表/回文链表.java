package com.boshrong.leetcode.链表;

public class 回文链表 {
    // 思想: 先将链表二分，将后面翻转，在一个一个比较
    public boolean isPalindrome(ListNode head) {
        // 翻转链表

        //快慢指针分成两份
        ListNode fast =head, slow = head,br = head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            if(fast==null || fast.next==null){
                br =slow;
            }
            slow = slow.next;
        }
        br.next = null;
        ListNode p1 = reverse(slow);
        while(p1!=null && head!=null){
            if(p1.val !=head.val){
                return false;
            }
            p1 = p1.next;
            head = head.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode vhead = new ListNode(0);
        vhead.next = null;
        ListNode next = head;
        while(head!=null){
            next = head.next;
            // 这里出错 head.next 赋值为null
            head.next = vhead.next;
            vhead.next = head;
            head = next;
        }
        return vhead.next;
    }
}
