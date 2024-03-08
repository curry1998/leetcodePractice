package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;

public class 判断是否为平衡二叉树jz79 {
    // 先序遍历每一个节点，判断每个节点是否是平衡二叉树。
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root == null){
            return true;
        }
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if(Math.abs(left-right) > 1){
            return false;
        }
        boolean isleft = IsBalanced_Solution(root.left);
        boolean isright = IsBalanced_Solution(root.right);
        return isleft&&isright;
    }

    // 获取某个节点最大的深度
    int getDepth(TreeNode proot){
        if(proot == null){
            return 0;
        }
        int left = getDepth(proot.left);
        int right = getDepth(proot.right);
        return left > right? left+1 : right+1;
    }
}
