package com.boshrong.leetcode.链表;

public class 两数相加2 {


    public static void main(String[] args) {

    }
    public  static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        int n1,n2,carry=0;
        ListNode current=headNode;
        while(l1!=null||l2!=null||carry!=0){
            if(l1==null){
                n1=0;
            }else{
                n1=l1.val;
                l1=l1.next;
            }
            if(l2==null){
                n2=0;
            }else{
                n2= l2.val;
                l2=l2.next;
            }
            //要创建一个新结点
            current.next=new ListNode((n1+n2+carry)%10);
            current=current.next;
            carry=(n1+n2+carry)/10;
        }
        return  headNode.next;


    }
}





