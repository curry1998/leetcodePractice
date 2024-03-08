package com.boshrong.leetcode.树;

public class 另一颗树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // 思想 先先序遍历，遍历每个节点，每个节点进行判断。
        if(root==null) {
            return false;
        }
        return dfs(root,subRoot) || isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    // 判断是否拥有相同的子结构
    public boolean dfs(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null || subRoot == null){
            return false;
        }
        if(root.val != subRoot.val){
            return false;
        }
        return dfs(root.left,subRoot.left) && dfs(root.right,subRoot.right);
    }
}
