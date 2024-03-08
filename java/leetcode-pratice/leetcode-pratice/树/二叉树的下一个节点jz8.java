package com.boshrong.leetcode.树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的下一个节点jz8 {


    List<TreeLinkNode> arrayList = new ArrayList<>();
    public void midOrder(TreeLinkNode node){
        if(node==null){
            return;
        }
        midOrder(node.left);
        arrayList.add(node);
        midOrder(node.right);
    }
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(pNode==null){
            return null;
        }
        TreeLinkNode treeLinkNode = new TreeLinkNode(0);
        treeLinkNode=pNode;

        while(pNode.next!=null){
            pNode=pNode.next;
        }
        //采用暴力的方法解决，先找到根节点，然后进行遍历，将其存储在数组中，从数组中获取其的下一个。
        midOrder(pNode);

        int lens=arrayList.size();
        for(int i=0;i<lens;i++){
            if(arrayList.get(i)==treeLinkNode){
                if(i+1>=lens){
                    return null;
                }else {
                    return arrayList.get(i+1);
                }
            }
        }
        return null;
    }
}


 class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
