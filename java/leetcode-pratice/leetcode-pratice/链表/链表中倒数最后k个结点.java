package com.boshrong.leetcode.链表;

public class 链表中倒数最后k个结点 {
}




 class ListNode {

    int val;
    ListNode next = null;
    public ListNode(int val) {
      this.val = val;
    }
  }
class Solution7 {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pHead ListNode类
     * @param k int整型
     * @return ListNode类
     */
    public ListNode FindKthToTail (ListNode pHead, int k) {
        // write code here
        //双指针题，快慢指针
        if(pHead==null||k<0){
            return null;
        }
        ListNode leftCurrent=pHead;
        ListNode rightCurrent=pHead;
        int right=0;
        while (right!=k){
            if(rightCurrent==null)
                return null;
            rightCurrent=rightCurrent.next;

            right++;
        }
        while(rightCurrent!=null){
            rightCurrent=rightCurrent.next;
            leftCurrent=leftCurrent.next;

        }
        return rightCurrent;


    }
}
