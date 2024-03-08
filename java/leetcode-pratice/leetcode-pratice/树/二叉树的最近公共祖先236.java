package com.boshrong.leetcode.树;

public class 二叉树的最近公共祖先236 {
    TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root,p,q);
        return res;
    }
    // 后序遍历
    // 判断 pq 是否在其左右孩子
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return false;
        }
        boolean left = dfs(root.left, p,q);
        boolean right = dfs(root.right, p,q);
        if((left && right) || (left || right) && (root.val == p.val || root.val == q.val)){
            res = root;
            return false;
        }
        return left|| right || root.val == p.val || q.val ==root.val;
    }
}
