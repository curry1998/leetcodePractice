package com.boshrong.leetcode.dfs;

import com.boshrong.leetcode.TreeNode;

public class 相同的树100 {

    public Boolean dfs(TreeNode p,TreeNode q){
        // 遇到空节点
        if(p==null && q==null){
            return true;
        }
        // 一个为空 一个不为空 返回false
        if(p==null || q==null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        //看左孩子是否相同
        boolean left=dfs(p.left,q.left);
        // 看右孩子是否相同
        boolean right=dfs(p.right,q.right);
        return left&&right;

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return dfs(p,q);
    }
}
