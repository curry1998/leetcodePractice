package com.boshrong.leetcode.微软面试;

import com.boshrong.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的中序遍历 {

    public void midOrder(TreeNode root, ArrayList<Integer> list){
        if(root==null){
            return;
        }
        midOrder(root.left,list);
        list.add(root.val);
        midOrder(root.right,list);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        midOrder(root,res);
        return res;
    }
}
