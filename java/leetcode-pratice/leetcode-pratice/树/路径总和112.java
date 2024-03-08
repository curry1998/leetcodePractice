package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;

public class 路径总和112 {

    public static void main(String[] args) {

    }
    public int count=0;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }

        count+=root.val;
        if(root.left==null && root.right==null){
            if(count==targetSum){
                return true;
            }
        }
        boolean left=hasPathSum(root.left,targetSum);
        boolean right=hasPathSum(root.right,targetSum);
        count-=root.val;
        return left||right;

    }
}
