package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;

public class 二叉树中和某一值的路径jz82 {
    //这道题和路径总和一模一样

    public int count=0;
    public boolean hasPathSum (TreeNode root, int sum) {
        if(root==null){
            return false;
        }

        count+=root.val;
        if(root.left==null && root.right==null){
            if(count==sum){
                return true;
            }
        }
        boolean left=hasPathSum(root.left,sum);
        boolean right=hasPathSum(root.right,sum);
        count-=root.val;
        return left||right;
    }
}
