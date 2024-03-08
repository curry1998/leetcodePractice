package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;

public class 对称二叉树101 {

    public boolean isSymRec(TreeNode left,TreeNode right){
        if(left==null && right==null){
            return true;
        }
        if(left==null || right==null){
            return false;
        }

        if(left.val==right.val){
            boolean flag=isSymRec(left.left,right.right);
            boolean flag2=isSymRec(left.right,right.left);
            return flag&&flag2;
        }else{
            return false;
        }
    }


    public boolean isSymmetric(TreeNode root) {
        if(root==null)
            return true;
        Boolean flag=isSymRec(root.left,root.right);
        return flag;
    }
}
