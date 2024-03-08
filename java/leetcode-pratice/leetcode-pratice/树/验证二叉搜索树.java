package com.boshrong.leetcode.树;

public class 验证二叉搜索树 {
    double pre = -Double.MAX_VALUE;
    public boolean isValidBST(TreeNode root) {
        // 二叉树 是否是平衡树
        // 使用中序遍历，定义一个中序遍历的前驱 pre的 val 值
        if(root==null){
            return true;
        }
        boolean left =isValidBST(root.left);
        if(root.val<=pre){
            return false;
        }

        pre=root.val;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
