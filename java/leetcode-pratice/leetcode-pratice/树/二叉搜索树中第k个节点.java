package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;

import java.util.ArrayList;

public class 二叉搜索树中第k个节点 {
    public void midOrder(TreeNode root,ArrayList<TreeNode> list){
        if(root==null)
            return;

        midOrder(root.left,list);
        list.add(root);
        midOrder(root.right,list);

    }

    TreeNode KthNode(TreeNode root, int k)
    {
        ArrayList<TreeNode> list = new ArrayList<>();
        if(root==null || k==0)
            return null;
        midOrder(root,list);
        int length=list.size();
        if(k>length)
            return null;
        return list.get(k-1);
    }
}
