package com.boshrong.leetcode.树;

public class 把二叉搜索树转化为累加树 {
    int num;
    public TreeNode convertBST(TreeNode root) {
        // 思路: 搜索路径，一个类似于搜索的题目
        // 先搜索右孩子之和，再搜索左孩子之和
        // 建立表树为先序遍历，搜索先右后左
        // 用一个值保存累加值,更新root.val
        if(root!=null){
            convertBST(root.right);
            root.val+=num;
            num=root.val;
            convertBST(root.left);
            return root;

        }
        return null;
    }
}
