package com.boshrong.leetcode.dfs;

import com.boshrong.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class 不同的二叉搜索树二 {
    public static void main(String[] args) {
        generateTrees(3);
    }
    public static List<TreeNode> generateTrees(int n) {
        // 思想: 给定n ,以1~n 中某一个为根节点，则左孩子为左边遍历为左孩子（充当根节点），右孩子为右边遍历，为右孩子（充当根节点）
        // 不断的去进行递归
        if(n==0){
            return null;
        }
        return build(1,n);
    }

    // 要规定一个区间，左孩子和右孩子
    public static List<TreeNode> build(int s, int e){

        List<TreeNode> ans= new ArrayList<>();
        if(s > e){
            //返回空的集合
            ans.add(null);
            return ans;
        }
        //遍历这个区间的所有节点
        for(int i=s;i<=e;i++){
            //以i 为根节点去构造,以左边孩子为其左孩子的根节点，右边孩子为其右边孩子的根节点
            List<TreeNode> left = build(s,i-1);
            List<TreeNode> right = build(i+1,e);
            //遍历左边和右边
            for(TreeNode l : left){
                for(TreeNode r: right){
                    TreeNode newNode= new TreeNode(i);
                    newNode.left = l;
                    newNode.right = r;
                    ans.add(newNode);
                }
            }
        }
        return ans;
    }
}
