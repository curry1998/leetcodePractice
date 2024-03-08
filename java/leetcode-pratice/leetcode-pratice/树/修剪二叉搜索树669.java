package com.boshrong.leetcode.树;

public class 修剪二叉搜索树669 {
    //可以看作是一个有序的数组。
    // 如果遍历到一个节点，其满足条件 小于low 或大于 high，则将其右孩子赋值给父节点。
    // 其的具体操作是， 如果当前节点的元素小于low的数值，那么递归右子树，并返回右子树满足条件的头节点。
    // 如果root(当前节点)的元素大于high的，那么应该递归左子树，并返回左子树符合条件的头结点。
    // 通过返回来移除元素
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null){
            return null;
        }
        if(root.val < low){
            return trimBST(root.right,low,high);
        }
        if(root.val > high){
            // 符合条件的在其左子树
            return trimBST(root.left, low ,high);
        }
        // 满足条件的继续递归。
        root.left = trimBST(root.left,low,high);
        root.right = trimBST(root.right,low,high);
        return root;
    }



}
