package com.boshrong.leetcode.树;

import com.boshrong.leetcode.TreeNode;

public class 二叉树中和为某一数值的路径三jz84 {

    //定义一个find 函数，从当前节点找
    public int Find(TreeNode root,int sum,int currentValue){
        if(root==null){
            return 0;
        }
        int count=0;
        if(currentValue+root.val==sum){
            // 这里不能返回
            count=1;
        }
        currentValue=currentValue+root.val;
        int left=Find(root.left,sum,currentValue);
        int right=Find(root.right,sum,currentValue);
        return count+left+right;
    }
    //每个节点都遍历一遍
    public int FindPath (TreeNode root, int sum) {
        // write code here
        if(root==null){
            return 0;
        }
        int count=Find(root,sum,0);
        int left=FindPath(root.left,sum);
        int right=FindPath(root.right,sum);
        return count+left+right;

    }
}
