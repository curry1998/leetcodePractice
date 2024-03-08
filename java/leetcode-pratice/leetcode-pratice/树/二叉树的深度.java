package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;

public class 二叉树的深度 {

    public static void main(String[] args) {

    }
    public int maxDepth(TreeNode root) {
        if(root.left==null&& root.right==null){
            return 1;
        }
        int left_depth=maxDepth(root.left);
        int right_depth=maxDepth(root.right);
        //+1 是为了带上自己
        return Math.max(left_depth,right_depth)+1;
    }
}
