package com.boshrong.leetcode.树;

public class 二叉搜索树中的插入操作701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        dfs(root,val);
        return root;
    }
    public void dfs(TreeNode root, int val){


        if(root.val > val && root.left == null ){
            TreeNode tmp = new TreeNode(val);
            root.left = tmp;
            return ;
        }else if(root.left != null && root.val > val){
            dfs(root.left,val);
        }

        if(root.val < val && root.right == null ){
            TreeNode tmp = new TreeNode(val);
            root.right = tmp;
            return ;
        }else if(root.right != null && root.val < val){
            dfs(root.right,val);
        }
    }
}
