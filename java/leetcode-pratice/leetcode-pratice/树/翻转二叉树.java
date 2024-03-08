package com.boshrong.leetcode.树;

public class 翻转二叉树 {
    public TreeNode invertTree(TreeNode root) {
        // 后序遍历，从下往上
        if(root==null){
            return null;
        }
        TreeNode newNode = new TreeNode(root.val);
        newNode.left = invertTree(root.right);
        newNode.right = invertTree(root.left);
        return newNode;
    }
}
