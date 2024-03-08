package com.boshrong.leetcode.树;

public class 二叉搜索树的最小绝对差 {
    int minValue = Integer.MAX_VALUE;
    TreeNode pre ;
    public int getMinimumDifference(TreeNode root) {
        if(root == null){
            return 0;
        }
        dfs(root);
        return minValue;
    }
    public void dfs(TreeNode root){
        if(root == null){
            return ;
        }
        dfs(root.left);
        if(pre != null && Math.abs(root.val - pre.val) < minValue){
            minValue = Math.abs(root.val - pre.val);
        }
        pre = root;
        dfs(root.right);
    }
}
