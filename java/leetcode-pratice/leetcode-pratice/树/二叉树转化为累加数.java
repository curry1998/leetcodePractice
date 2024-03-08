package com.boshrong.leetcode.树;

public class 二叉树转化为累加数 {
    // 自己想的是建立一个数太菜了
    int parent;
    int preparent;
    public TreeNode convertBST(TreeNode root) {
        // 思路: 搜索路径，一个类似于搜索的题目
        // 先搜索右孩子之和，再搜索左孩子之和
        // 建立表树为先序遍历，搜索先右后左
        if (root==null){
            return null;
        }
        return buildTree(root,false);
    }

    public TreeNode buildTree(TreeNode root,boolean isLeft){
        //计算一个节点及其孩子的总和
        if(root==null){
            return null;
        }
        int val=sum(root.right);
        TreeNode newNode;
        if(isLeft){
            newNode=new TreeNode(val+root.val+parent);
            parent+=val+root.val;
        }else{
            newNode=new TreeNode(val+root.val);
            parent=val+root.val;
        }

        newNode.left=buildTree(root.left,true);
        newNode.right=buildTree(root.right,false);
        return newNode;
    }
    public int sum(TreeNode root){
        if(root==null){
            return 0;
        }
        return sum(root.left)+sum(root.right)+root.val;

    }
}
