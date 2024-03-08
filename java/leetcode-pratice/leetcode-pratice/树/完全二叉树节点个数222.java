package com.boshrong.leetcode.树;

public class 完全二叉树节点个数222 {
    public int countNodes(TreeNode root) {
        // 简单的是用一个队列层序遍历或直接遍历就行， 比o(n) 更快的时间复杂度
        if(root == null){
            return 0;
        }
        int leftNum = countNodes(root.left);
        int rightNum = countNodes(root.right);
        return leftNum + rightNum +1;
    }
}
