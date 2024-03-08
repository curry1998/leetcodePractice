package com.boshrong.leetcode.链表;

import java.util.HashSet;

public class 环形链表 {
    public boolean hasCycle(ListNode head) {
        //使用hashset 空间复杂度 o(n)
        HashSet<ListNode> set=new HashSet<>();
        ListNode work=head;
        while(work.next!=null){
            if(set.contains(work)){
                return false;
            }
            set.add(work);
            work=work.next;
        }
        return true;
    }
}
