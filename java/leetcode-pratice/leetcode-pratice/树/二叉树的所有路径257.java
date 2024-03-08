package com.boshrong.leetcode.树;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径257 {
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        if(root == null){
            return res;
        }
        dfs(root, "");
        return res;
    }
    public void dfs(TreeNode root, String s){
        s += root.val;
        if(root.left == null && root.right == null){
            res.add(s);
            return ;
        }
        if(root.left != null)
            dfs(root.left, s+"->");
        if(root.right != null)
            dfs(root.right, s+"->");
    }
}
