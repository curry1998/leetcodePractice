package com.boshrong.leetcode.树;

public class 二叉搜索数的搜索700 {

        public TreeNode searchBST(TreeNode root, int val) {
            // 思想:
            if(root == null){
                return null;
            }
            if(root.val == val){
                return root;
            }else if(root.val > val){
                TreeNode left = searchBST(root.left,val);
                if(left != null){
                    return left;
                }
            }else{
                TreeNode right = searchBST(root.right,val);
                if(right != null){
                    return right;
                }
            }
            return null;
        }


}
