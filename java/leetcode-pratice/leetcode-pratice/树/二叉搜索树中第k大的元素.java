package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;

import java.util.ArrayList;

public class 二叉搜索树中第k大的元素 {

    public void midOrder(TreeNode root,ArrayList<Integer> list){
        if(root==null)
            return;

        midOrder(root.left,list);
        list.add(root.val);
        midOrder(root.right,list);

    }

    public int kthLargest(TreeNode root, int k) {

        if(root==null)
            return 0;
        ArrayList<Integer> list = new ArrayList<>();
        midOrder(root,list);
        int length=list.size();
        return list.get(length-k);
    }
}
