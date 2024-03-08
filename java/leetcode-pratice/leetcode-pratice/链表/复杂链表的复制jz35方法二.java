package com.boshrong.leetcode.链表;






public class 复杂链表的复制jz35方法二 {

    //下面代码是正确的，但是为了与方法一做区别,进行了注释。

    //通过复制节点实现
//    public com.boshrong.leetcode.树.Node copyRandomList(com.boshrong.leetcode.树.Node head) {
//        if(head==null){
//            return head;
//        }
//        //进行复制
//        com.boshrong.leetcode.树.Node workPointer = head;
//        while(workPointer!=null){
//            com.boshrong.leetcode.树.Node node = new com.boshrong.leetcode.树.Node(workPointer.val);
//            node.next=workPointer.next;
//            workPointer.next=node;
//            workPointer=workPointer.next.next;
//        }
//        // random node 复制
//        workPointer=head;
//        while(workPointer!=null){
//            if(workPointer.random!=null)
//                //此时是已经复制的节点,所以要用workPointer.random.next;next 表示复制的节点
//                workPointer.next.random=workPointer.random.next;
//            workPointer=workPointer.next.next;
//        }
//
//
//        //将新生成的复制节点进行合并,发现这样做的话workload 必须是next为空，所以做的是错的
//        //将链表一分为二
//        //拷贝节点的头
//        com.boshrong.leetcode.树.Node copyHead=head.next;
//        //两个工作指针
//        com.boshrong.leetcode.树.Node copyworker=head.next;
//        workPointer=head;
//        while(workPointer!=null){
//            workPointer.next=workPointer.next.next;
//            workPointer=workPointer.next;
//            if(copyworker.next!=null){
//                copyworker.next=copyworker.next.next;
//                copyworker=copyworker.next;
//            }
//        }
//        return copyHead;
//    }
}
